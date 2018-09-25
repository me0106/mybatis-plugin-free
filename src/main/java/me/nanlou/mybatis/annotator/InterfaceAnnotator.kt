package me.nanlou.mybatis.annotator

import com.intellij.codeInsight.daemon.impl.AnnotationHolderImpl
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.components.ServiceManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiJavaFile
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import me.nanlou.mybatis.service.XmlMapperService
import me.nanlou.mybatis.utils.XmlMapperCache

/**
 * @author me
 * @date 2018-08-18 15:06
 */
class InterfaceAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is PsiJavaFile) {
            return
        }
        holder as AnnotationHolderImpl
        val clazz = element.classes.getOrNull(0) ?: return
        val list = XmlMapperService.getInstance(element.project).findMappers(element.project)
        val mapper = list.find { it.rootElement.namespace.value == clazz }?.rootElement ?: return
        val xmlMethods = DomUtil.getChildrenOf(mapper, CurdElement::class.java).map { it.id.value }
        val interfaceMethods = clazz.methods.filter { it !in xmlMethods }
        interfaceMethods.forEach {
            holder.createErrorAnnotation(it.nameIdentifier!!, "Unresolved Sql Statement: ${it.name} ")
        }
    }
}
