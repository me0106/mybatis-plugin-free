package me.nanlou.mybatis.linemarker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.xml.XmlFile
import com.intellij.psi.xml.XmlToken
import com.intellij.psi.xml.XmlTokenType
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import me.nanlou.mybatis.utils.Icons
import me.nanlou.mybatis.utils.MapperUtils
import me.nanlou.mybatis.utils.MyDomManager
import me.nanlou.mybatis.utils.addWithReplace

/**
 * @author me
 * @date 2018-08-14 19:22
 */
class XmlToJavaLineMarker : RelatedItemLineMarkerProvider() {

    companion object {
        val statement = arrayOf("insert", "delete", "update", "select")
        const val MAPPER = "mapper"
    }

    private fun isSupport(element: PsiElement): Boolean {
//        是否Mapper.xml文件
        if (MapperUtils.isNotMapperXml(element.containingFile)) {
            return false
        }
        if (element !is XmlToken || element.prevSibling !is XmlToken) {
            return false
        }
        if (element.tokenType != XmlTokenType.XML_NAME) {
            return false
        }
//      是否标签开始位置
        if ((element.prevSibling as XmlToken).tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }
        return true
    }


    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>) {
        if (!isSupport(element)) {
            return
        }
        val mapper = MyDomManager.getDomModel(element.containingFile as XmlFile, Mapper::class.java) ?: return
        //如果是<mapper/>标签
        if (element.text == MAPPER) {
            result.addWithReplace(buildNamespaceLineMaker(mapper, mapper.xmlTag!!.children[1] as XmlToken))
        }
        //如果是<select/>之类的标签
        if (element.text in statement) {
            val curdElement = DomUtil.findDomElement(element, CurdElement::class.java) ?: return
            result.addWithReplace(buildSqlLineMarker(curdElement, element.prevSibling as XmlToken))
        }
    }

    /**
     * 绑定namespace->Class的跳转
     */
    private fun buildNamespaceLineMaker(mapper: Mapper, xmlToken: XmlToken): RelatedItemLineMarkerInfo<PsiElement>? {
        val clazz = mapper.namespace.value ?: return null
        val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON)
                .setTargets(clazz)
                .setAlignment(GutterIconRenderer.Alignment.CENTER)
                .setTooltipText("Navigate to java interface: ${clazz.name}")
        return builder.createLineMarkerInfo(xmlToken)
    }


    /**
     * 绑定sql->method的跳转
     */
    private fun buildSqlLineMarker(element: CurdElement, xmlToken: XmlToken): RelatedItemLineMarkerInfo<PsiElement>? {
        val clazz = DomUtil.getParentOfType(element, Mapper::class.java, true)?.namespace?.value
        val methods = clazz?.methods.orEmpty().filter { it.name == element.id.xmlAttribute?.value }
        val psiMethod = element.id.value ?: return null
        return NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON)
                .setTargets(methods)
                .setAlignment(GutterIconRenderer.Alignment.CENTER)
                .setTooltipText("Navigate to java method: ${psiMethod.containingClass!!.name}.${psiMethod.name}")
                .createLineMarkerInfo(xmlToken)
    }
}