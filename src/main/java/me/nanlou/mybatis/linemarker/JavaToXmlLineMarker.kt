package me.nanlou.mybatis.linemarker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import me.nanlou.mybatis.utils.XmlMapperCache
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.utils.Icons

/**
 * @author me
 * @date 2018-08-14 19:22
 */
class JavaToXmlLineMarker : RelatedItemLineMarkerProvider() {


    override fun collectNavigationMarkers(elements: MutableList<PsiElement>, result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>, forNavigation: Boolean) {
        val psiClass = elements.find { it is PsiClass }
        val list = listOf(psiClass).filter { it != null }
        super.collectNavigationMarkers(list, result, forNavigation)
    }

    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>) {
        if (element !is PsiClass) {
            return
        }
        val mapper = XmlMapperCache.findMapper(element, element.project) ?: return
        result.add(buildClassLineMarker(element, mapper))
        result.addAll(buildMethodLineMarker(element, mapper))
    }


    /**
     * 添加Class->namespace跳转
     */
    private fun buildClassLineMarker(clazz: PsiClass, mapper: Mapper): RelatedItemLineMarkerInfo<PsiElement> {
        val file = mapper.xmlTag.containingFile
        val builder = NavigationGutterIconBuilder.create(Icons.JAVA_TO_XML_ICON)
                .setTarget(mapper.namespace.xmlAttributeValue)
                .setTooltipText("Navigate to  Mapper Xml:${file.name}")
        return builder.createLineMarkerInfo(clazz.nameIdentifier!!)
    }


    /**
     * 添加method->sql跳转
     */
    private fun buildMethodLineMarker(clazz: PsiClass, mapper: Mapper): List<RelatedItemLineMarkerInfo<PsiElement>> {
        val list = ArrayList<RelatedItemLineMarkerInfo<PsiElement>>()
        clazz.methods.forEach { method ->
            val targetTag = mapper.xmlTag.subTags.find { it.getAttributeValue("id") == method.name } ?: return@forEach
            val builder = NavigationGutterIconBuilder.create(Icons.JAVA_TO_XML_ICON)
                    .setTarget(targetTag.getAttribute("id")!!.valueElement)
                    .setTooltipText("Navigate to  Mapper Statement: ${targetTag.value.text}")
            list.add(builder.createLineMarkerInfo(method))
        }
        return list
    }


}
