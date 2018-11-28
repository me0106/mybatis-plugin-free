package me.nanlou.mybatis.converter

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.util.xml.ConvertContext
import com.intellij.util.xml.Converter
import com.intellij.util.xml.CustomReferenceConverter
import com.intellij.util.xml.GenericDomValue
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.utils.Icons
import me.nanlou.mybatis.utils.MyDomManager


/**
 * @author me
 * @date  2018-08-16 09:53
 */
open class MethodConverter : Converter<PsiMethod>(), CustomReferenceConverter<PsiMethod> {
    override fun createReferences(value: GenericDomValue<PsiMethod>?, element: PsiElement?, context: ConvertContext?): Array<PsiReference> {
        return arrayOf(PsiMethodReference(element!!, value, context))
    }


    override fun toString(t: PsiMethod?, context: ConvertContext?): String? {
        return t.toString()
    }

    override fun fromString(s: String?, context: ConvertContext?): PsiMethod? {
        val mapper = MyDomManager.getDomModel(context!!.file, Mapper::class.java) ?: return null
        return mapper.namespace.value?.findMethodsByName(s, false)?.getOrNull(0)
    }

    private class PsiMethodReference constructor(element: PsiElement, val value: GenericDomValue<PsiMethod>?, val context: ConvertContext?) : PsiReferenceBase<PsiElement>(element) {
        override fun resolve(): PsiElement? {
            return value?.value
        }

        override fun getVariants(): Array<Any> {
            val clazz = MyDomManager.getDomModel(context?.file, Mapper::class.java)?.namespace?.value
            return clazz?.methods.orEmpty().map { builder(it) }.toTypedArray()
        }

        private fun builder(method: PsiMethod): LookupElement {
            return LookupElementBuilder.create(method.name).bold().withIcon(Icons.JAVA_METHOD_ICON)
        }
    }


}