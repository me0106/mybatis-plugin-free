package me.nanlou.mybatis.completion

import com.intellij.codeInsight.completion.*
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.patterns.XmlFilePattern
import com.intellij.psi.xml.XmlAttribute
import com.intellij.psi.xml.XmlAttributeValue
import com.intellij.psi.xml.XmlFile
import com.intellij.psi.xml.XmlTokenType
import com.intellij.util.ProcessingContext

/**
 * @author me
 * @date 2018-09-27 00:16
 */
class MethodCompletionContributor : CompletionContributor() {
    init {
        val patterns = PlatformPatterns.psiElement(XmlAttributeValue::class.java)
//                .inFile(PlatformPatterns.psiFile(XmlFile::class.java))
//                .withParent(PlatformPatterns.psiElement(XmlAttribute::class.java))
        extend(CompletionType.BASIC, patterns, Provider())
    }


    private class Provider : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            println(parameters)
        }
    }
}
