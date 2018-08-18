package me.nanlou.mybatis.linemarker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.xml.XmlTag
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.Mapper
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
        element as XmlTag
        val marker = buildNamespaceLineMaker(element) ?: return
        result.add(marker)
        result.addAll(buildSqlLineMarker(element))
    }


    private fun buildNamespaceLineMaker(xmlTag: XmlTag): RelatedItemLineMarkerInfo<PsiElement>? {
        val mapper = DomUtil.findDomElement(xmlTag, Mapper::class.java)!!
        val clazz = mapper.namespace.value ?: return null
        val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON)
                .setTarget(clazz).setTooltipText("Navigate to java interface: ${clazz.name}")
        return builder.createLineMarkerInfo(xmlTag)
    }


    private fun buildSqlLineMarker(xmlTag: XmlTag): List<RelatedItemLineMarkerInfo<PsiElement>> {
        val markersList = ArrayList<RelatedItemLineMarkerInfo<PsiElement>>()
        val mapper = DomUtil.findDomElement(xmlTag, Mapper::class.java)!!
        mapper.inserts.filter {
            it.id.value != null
        }.forEach {
            val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON).setTarget(it.id.value).setTooltipText("Navigate to java interface: ${it.id.value!!.name}")
            markersList.add(builder.createLineMarkerInfo(it.id.xmlAttributeValue!!))
            return@forEach
        }
        mapper.deletes.filter {
            it.id.value != null
        }.forEach {
            val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON).setTarget(it.id.value).setTooltipText("Navigate to java interface: ${it.id.value!!.name}")
            markersList.add(builder.createLineMarkerInfo(it.id.xmlAttributeValue!!))
            return@forEach
        }
        mapper.updates.filter {
            it.id.value != null
        }.forEach {
            val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON).setTarget(it.id.value).setTooltipText("Navigate to java interface: ${it.id.value!!.name}")
            markersList.add(builder.createLineMarkerInfo(it.id.xmlAttributeValue!!))
            return@forEach
        }
        mapper.selects.filter {
            it.id.value != null
        }.forEach {
            val builder = NavigationGutterIconBuilder.create(Icons.XML_TO_JAVA_ICON).setTarget(it.id.value).setTooltipText("Navigate to java interface: ${it.id.value!!.name}")
            markersList.add(builder.createLineMarkerInfo(it.id.xmlAttributeValue!!))
            return@forEach
        }
        return markersList
    }
}
