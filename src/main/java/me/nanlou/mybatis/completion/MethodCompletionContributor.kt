package me.nanlou.mybatis.completion

import com.intellij.codeInsight.completion.*
import com.intellij.lang.xml.XMLLanguage
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.xml.XmlTokenType
import com.intellij.util.ProcessingContext

/**
 * @author me
 * @date 2018-09-27 00:16
 */
class MethodCompletionContributor : CompletionContributor() {
    init {
        val patterns = PlatformPatterns.psiElement()
                .withLanguage(XMLLanguage.INSTANCE)
                .withElementType(XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN)
        extend(CompletionType.BASIC, patterns, Provider())
    }


    private class Provider : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        }
    }
}
