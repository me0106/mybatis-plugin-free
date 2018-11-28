package me.nanlou.mybatis.linemarker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiIdentifier
import com.intellij.psi.PsiMethod
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.service.XmlMapperService
import me.nanlou.mybatis.utils.Icons
import java.util.*

/**
 * @author me
 * @date 2018-08-14 19:22
 */
class JavaToXmlLineMarker : RelatedItemLineMarkerProvider() {


    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>) {
        val mapperList = XmlMapperService.getInstance(element.project).findMappers(element.project).map { it.rootElement }
        if (element !is PsiIdentifier) {
            return
        }
        result.addAll(doCollect(element, mapperList))
    }


    private fun doCollect(element: PsiElement, mappers: List<Mapper>): List<RelatedItemLineMarkerInfo<PsiElement>> {
        val list = LinkedList<RelatedItemLineMarkerInfo<PsiElement>>()
        //如果是类标识符
        if (element.parent is PsiClass) {
            val clazz = element.parent as PsiClass
            if (clazz.name == element.text) {
                val mark = buildClassLineMarker(clazz, mappers.filter { it.namespace.value == clazz })
                if (mark != null) {
                    list.add(mark)
                }
            }
        }
        //如果是method标识符
        if (element.parent is PsiMethod) {
            val clazz = (element.parent as PsiMethod).containingClass ?: return list
            val mark = buildMethodLineMarker(element.parent as PsiMethod, mappers.filter { it.namespace.value == clazz })
            if (mark != null) {
                list.add(mark)
            }
        }
        return list.reversed()
    }


    /**
     * 添加Class->namespace跳转
     */
    private fun buildClassLineMarker(clazz: PsiClass, list: List<Mapper>): RelatedItemLineMarkerInfo<PsiElement>? {
        if (list.isEmpty()) {
            return null
        }
        val builder = NavigationGutterIconBuilder.create(Icons.JAVA_TO_XML_ICON)
                .setTargets(list.map { it.xmlTag })
                .setAlignment(GutterIconRenderer.Alignment.CENTER)
                .setTooltipText("Navigate to  Mapper Xml")
        return builder.createLineMarkerInfo(clazz.nameIdentifier!!)
    }


    /**
     * 添加method->sql跳转
     */
    private fun buildMethodLineMarker(method: PsiMethod, list: List<Mapper>): RelatedItemLineMarkerInfo<PsiElement>? {
        val xmlList = list.flatMap { it.xmlTag!!.subTags.toList() }.filter { it.getAttributeValue("id") == method.name }
        if (xmlList.isEmpty()) {
            return null
        }
        return NavigationGutterIconBuilder.create(Icons.JAVA_TO_XML_ICON)
                .setTargets(xmlList)
                .setAlignment(GutterIconRenderer.Alignment.CENTER)
                .setTooltipText("Navigate to  Mapper.xml")
                .createLineMarkerInfo(method.nameIdentifier!!)
    }
}
