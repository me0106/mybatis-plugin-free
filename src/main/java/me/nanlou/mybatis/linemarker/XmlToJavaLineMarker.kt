package me.nanlou.mybatis.linemarker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.xml.XmlFile
import com.intellij.psi.xml.XmlTag
import com.intellij.util.xml.DomManager
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.dom.sub.curd.SqlElement
import me.nanlou.mybatis.utils.Icons

/**
 * @author me
 * @date 2018-08-14 19:22
 */
class XmlToJavaLineMarker : RelatedItemLineMarkerProvider() {

    override fun collectNavigationMarkers(elements: MutableList<PsiElement>, result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>, forNavigation: Boolean) {
        val xmlTag = elements.find { it is XmlTag && it.name == "mapper" }
        val list = listOf(xmlTag).filter { it != null }
        super.collectNavigationMarkers(list, result, forNavigation)
    }

    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>) {
        if (element !is XmlTag) {
            return
        }
        val mapper = DomManager.getDomManager(element.project)
                .getFileElement(element.containingFile as XmlFile?, Mapper::class.java)?.rootElement ?: return
        val marker = buildNamespaceLineMaker(mapper) ?: return
        result.add(marker)
        result.addAll(buildSqlLineMarker(mapper))
    }

    /**
     * 绑定namespace->Class的跳转
     */
    private fun buildNamespaceLineMaker(mapper: Mapper): RelatedItemLineMarkerInfo<PsiElement>? {
        val clazz = mapper.namespace.value ?: return null
        val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON)
                .setTarget(clazz)
                .setTooltipText("Navigate to java interface: ${clazz.name}")
        return builder.createLineMarkerInfo(mapper.xmlTag)
    }


    /**
     * 绑定sql->method的跳转
     */
    private fun buildSqlLineMarker(mapper: Mapper): List<RelatedItemLineMarkerInfo<PsiElement>> {
        val list = DomUtil.getChildrenOf(mapper, SqlElement::class.java)
        val markersList = ArrayList<RelatedItemLineMarkerInfo<PsiElement>>()
        list.filter { it.id.value != null }.forEach {
            val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON)
                    .setTarget(it.id.value)
                    .setTooltipText("Navigate to java method: ${it.id.value!!.name}")
            markersList.add(builder.createLineMarkerInfo(it.id.xmlAttributeValue!!))
            return@forEach
        }
        return markersList
    }
}
