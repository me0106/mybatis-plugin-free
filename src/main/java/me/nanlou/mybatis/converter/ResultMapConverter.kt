package me.nanlou.mybatis.converter

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.xml.XmlTag
import com.intellij.util.xml.*
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.utils.Icons
import me.nanlou.mybatis.utils.MyDomManager

/**
 * @author me
 * @date 2018-09-30 18:28
 */
open class ResultMapConverter : Converter<XmlTag>(), CustomReferenceConverter<XmlTag> {
    override fun toString(t: XmlTag?, context: ConvertContext?): String? {
        return t?.toString()
    }

    override fun fromString(s: String?, context: ConvertContext?): XmlTag? {
        val mapper = MyDomManager.getDomModel(context?.file, Mapper::class.java)
        return mapper?.resultMaps.orEmpty().find { it.id.value == s }?.xmlTag
    }

    override fun createReferences(value: GenericDomValue<XmlTag>?, element: PsiElement, context: ConvertContext?): Array<PsiReference> {
        return arrayOf(MyReference(element, value, context))
    }


    private class MyReference constructor(element: PsiElement,
                                          val value: GenericDomValue<XmlTag>?,
                                          val context: ConvertContext?) : PsiReferenceBase<PsiElement>(element) {

        override fun resolve(): PsiElement? {
            return value?.value
        }

        override fun getVariants(): Array<Any> {
            val mapper = MyDomManager.getDomModel(context?.file, Mapper::class.java) ?: return emptyArray()
            return mapper.resultMaps.map { builder(it.id.value.orEmpty()) }.toTypedArray()
        }

        val builder = { id: String ->
            LookupElementBuilder.create(id).bold().withIcon(Icons.XML_LOGO)
        }
    }
}
