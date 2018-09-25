package me.nanlou.mybatis.linemarker

import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.codeInsight.daemon.impl.DaemonListeners
import com.intellij.codeInsight.daemon.impl.LineMarkersPass
import com.intellij.codeInsight.daemon.impl.LineMarkersPassFactory
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.ex.util.EditorUtil
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiIdentifier
import com.intellij.psi.PsiMethod
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.xml.XmlToken
import com.intellij.util.xml.DomService
import me.nanlou.mybatis.utils.XmlMapperCache
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.service.XmlMapperService
import me.nanlou.mybatis.utils.Icons
import org.jetbrains.kotlin.idea.inspections.findExistingEditor
import org.jetbrains.kotlin.j2k.getContainingClass

/**
 * @author me
 * @date 2018-08-14 19:22
 */
class JavaToXmlLineMarker : RelatedItemLineMarkerProvider() {


    override fun collectNavigationMarkers(element: PsiElement,
                                          result: MutableCollection<in RelatedItemLineMarkerInfo<PsiElement>>) {
        val mapperList = XmlMapperService.getInstance(element.project).findMappers(element.project).map { it.rootElement }
        if (element !is PsiIdentifier) {
            return
        }
        if (element.parent is PsiClass) {
            val clazz = element.parent as PsiClass
            if (clazz.name == element.text) {
                mapperList.filter { it.namespace.value == clazz }.forEach { result.add(buildClassLineMarker(clazz, it)) }
            }
        }
        if (element.parent is PsiMethod) {
            val clazz = (element.parent as PsiMethod).containingClass ?: return
            val mapper = mapperList.find { it.namespace.value == clazz } ?: return
            val marker = buildMethodLineMarker(element.parent as PsiMethod, mapper) ?: return
            result.add(marker)
        }
    }


    /**
     * 添加Class->namespace跳转
     */
    private fun buildClassLineMarker(clazz: PsiClass, mapper: Mapper): RelatedItemLineMarkerInfo<PsiElement> {
        val builder = NavigationGutterIconBuilder.create(Icons.JAVA_TO_XML_ICON)
                .setTarget(mapper.xmlTag)
                .setAlignment(GutterIconRenderer.Alignment.CENTER)
                .setTooltipText("Navigate to  Mapper Xml:${clazz.name}")
        return builder.createLineMarkerInfo(clazz.nameIdentifier!!)
    }


    /**
     * 添加method->sql跳转
     */
    private fun buildMethodLineMarker(method: PsiMethod, mapper: Mapper): RelatedItemLineMarkerInfo<PsiElement>? {
        val targetTag = mapper.xmlTag.subTags.find { it.getAttributeValue("id") == method.name } ?: return null
        val builder = NavigationGutterIconBuilder.create(Icons.JAVA_TO_XML_ICON)
                .setTarget(targetTag)
                .setAlignment(GutterIconRenderer.Alignment.CENTER)
                .setTooltipText("Navigate to  Mapper Statement: ${targetTag.value.text}")
        return builder.createLineMarkerInfo(method.nameIdentifier!!)
    }
}
