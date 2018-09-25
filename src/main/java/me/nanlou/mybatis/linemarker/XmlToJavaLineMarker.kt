package me.nanlou.mybatis.linemarker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.xml.*
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import me.nanlou.mybatis.utils.*
import java.lang.ClassCastException

/**
 * @author me
 * @date 2018-08-14 19:22
 */
class XmlToJavaLineMarker : RelatedItemLineMarkerProvider() {

    companion object {
        private val list = arrayOf("select", "mapper", "delete", "update", "insert")
    }

    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>) {
        if (MapperUtils.isNotMapperXml(element.containingFile)) {
            return
        }
        val mapper = MyDomManager.getDomModel(element.containingFile as XmlFile, Mapper::class.java) ?: return
        val list = DomUtil.getChildrenOf(mapper, CurdElement::class.java)
        try {
            result.addWithReplace(buildNamespaceLineMaker(mapper, mapper.xmlTag.children[1] as XmlToken))
            list.map { buildSqlLineMarker(it, it.xmlTag.children[1] as XmlToken) }.forEach { result.addWithReplace(it) }
        } catch (e: ClassCastException) {

        }

    }

    /**
     * 绑定namespace->Class的跳转
     */
    private fun buildNamespaceLineMaker(mapper: Mapper, xmlToken: XmlToken): RelatedItemLineMarkerInfo<PsiElement>? {
        val clazz = mapper.namespace.value ?: return null
        val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON)
                .setTarget(clazz.nameIdentifier)
                .setAlignment(GutterIconRenderer.Alignment.CENTER)
                .setTooltipText("Navigate to java interface: ${clazz.name}")
        return builder.createLineMarkerInfo(xmlToken)
    }


    /**
     * 绑定sql->method的跳转
     */
    private fun buildSqlLineMarker(element: CurdElement, xmlToken: XmlToken): RelatedItemLineMarkerInfo<PsiElement>? {
        val psiMethod = element.id.value ?: return null
        return NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON)
                .setTarget(psiMethod.nameIdentifier)
                .setAlignment(GutterIconRenderer.Alignment.CENTER)
                .setTooltipText("Navigate to java method: ${psiMethod.nameIdentifier}")
                .createLineMarkerInfo(xmlToken)
    }
}