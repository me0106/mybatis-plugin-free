package me.nanlou.mybatis.converter

import com.intellij.openapi.components.ServiceManager
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.xml.XmlAttributeValue
import com.intellij.util.xml.*
import me.nanlou.mybatis.service.TypeAliasService

/**
 * @author me
 * @date 2018-09-30 00:58
 */
class ParameterTypeConverter : PsiClassConverter(), CustomReferenceConverter<PsiClass> {
    override fun fromString(s: String?, context: ConvertContext): PsiClass? {
        if (s.orEmpty().contains('.')) {
            return super.fromString(s, context)
        }
        val instance = TypeAliasService.getInstance(context.project)
        return instance.findAliasPsiClass(s.orEmpty())

    }


    override fun createReferences(value: GenericDomValue<PsiClass>, element: PsiElement, context: ConvertContext): Array<PsiReference> {
        return if ((element as XmlAttributeValue).value.orEmpty().contains('.')) {
            super.createReferences(value, element, context)
        } else {
            emptyArray()
        }
    }


    private class MyReference constructor(element: PsiElement) : PsiReferenceBase<PsiElement>(element) {
        override fun resolve(): PsiElement? {
            TODO("not implemented")
        }

        override fun getVariants(): Array<Any> {
            TODO("not implemented")
        }
    }
}
