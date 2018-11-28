package me.nanlou.mybatis.reference

import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.XmlPatterns
import com.intellij.psi.*
import com.intellij.psi.xml.XmlAttribute
import com.intellij.psi.xml.XmlAttributeValue
import com.intellij.psi.xml.XmlFile
import com.intellij.util.ProcessingContext
import com.sun.deploy.xml.XMLAttribute
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.utils.Icons
import me.nanlou.mybatis.utils.MyDomManager

/**
 * @author me
 * @date 2018-10-02 16:57
 */
class ResultMapReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        val patterns = XmlPatterns.xmlAttributeValue()
                .withSuperParent(1, XmlPatterns.xmlAttribute("id"))
                .withSuperParent(2, XmlPatterns.xmlTag().withName("resultMap"))
        registrar.registerReferenceProvider(patterns, Provider())
    }


    private class Provider : PsiReferenceProvider() {

        override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            return arrayOf(MyReference(element as XmlAttributeValue))
        }
    }


    private class MyReference(element: XmlAttributeValue) : PsiReferenceBase<XmlAttributeValue>(element) {

        override fun resolve(): PsiElement? {

            return element
        }

        override fun getVariants(): Array<Any> {
            val mapper = MyDomManager.getDomModel(element.containingFile as XmlFile, Mapper::class.java)

            return mapper?.selects.orEmpty().map { it.resultMap }
                    .map { LookupElementBuilder.create(it.rawText!!).bold().withIcon(Icons.XML_LOGO) }
                    .toTypedArray()
        }
    }
}
