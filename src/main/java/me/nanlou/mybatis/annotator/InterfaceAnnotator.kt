package me.nanlou.mybatis.annotator

import com.intellij.codeInsight.daemon.impl.AnnotationHolderImpl
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiJavaFile
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.sub.curd.SqlElement
import me.nanlou.mybatis.utils.XmlMapperCache
import org.jetbrains.kotlin.idea.editor.fixers.range

/**
 * @author me
 * @date 2018-08-18 15:06
 */
class InterfaceAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is PsiJavaFile) {
            return
        }
        val holderImpl = holder as AnnotationHolderImpl
        val clazz = element.classes.getOrNull(0) ?: return
        val mapper = XmlMapperCache.findMapper(clazz, element.project) ?: return
        val xmlMethods = DomUtil.getChildrenOf(mapper, SqlElement::class.java).map { it.id.value }
        val interfaceMethods = clazz.methods.filter { !xmlMethods.contains(it) }
        interfaceMethods.forEach {
            holderImpl.createAnnotation(HighlightSeverity.ERROR, it.nameIdentifier!!.range, "Unresolved Sql Statement: ${it.name} ")
        }
    }
}
