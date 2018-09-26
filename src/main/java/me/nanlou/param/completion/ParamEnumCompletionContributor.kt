package me.nanlou.param.completion

import com.intellij.codeInsight.TailType
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.TailTypeDecorator
import com.intellij.ide.projectView.impl.nodes.PackageUtil
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiUtil
import com.intellij.util.ProcessingContext
import me.nanlou.mybatis.utils.Icons
import me.nanlou.param.ParamFile
import me.nanlou.param.ParamLanguage
import me.nanlou.param.psi.ParamJavaTypeValue
import me.nanlou.param.psi.ParamJdbcTypeValue
import me.nanlou.param.psi.ParamModeValue
import me.nanlou.param.psi.ParamTypes


/**
 * @author me
 * @date 2018-09-23 21:18
 */
class ParamEnumCompletionContributor : CompletionContributor() {
    init {
        initJdbcTypeCompletion()
        initModeCompletion()
        initQuoteCompletion()
    }

    //初始化括号里的提示，jdbcType,javaType,mode什么的
    private fun initQuoteCompletion() {
        val pattern = PlatformPatterns.psiElement()
                .afterLeaf(",")
                .withLanguage(ParamLanguage.INSTANCE)

        val provider = object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(parameters: CompletionParameters,
                                        context: ProcessingContext,
                                        result: CompletionResultSet) {
                keyWords.map { LookupElementBuilder.create(it).withIcon(Icons.MYBATIS_LOGO).bold() }
                        .forEach { result.addElement(TailTypeDecorator.withTail(it, TailType.createSimpleTailType('='))) }
            }
        }
        extendKeywordCompletion(pattern, provider)
    }

    //初始化jdbcType的值
    private fun initJdbcTypeCompletion() {
        val pattern = PlatformPatterns.psiElement(ParamTypes.IDENTIFIER)
                .withParent(PlatformPatterns.psiElement(ParamJdbcTypeValue::class.java))
                .withLanguage(ParamLanguage.INSTANCE)
        val provider = object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(parameters: CompletionParameters,
                                        context: ProcessingContext,
                                        result: CompletionResultSet) {
                jdbcTypes.map { LookupElementBuilder.create(it).withIcon(Icons.MYBATIS_LOGO).bold() }
                        .forEach { result.addElement(TailTypeDecorator.withTail(it, TailType.NONE)) }
            }
        }
        extendKeywordCompletion(pattern, provider)
    }

    //初始化mode的值
    private fun initModeCompletion() {
        val pattern = PlatformPatterns.psiElement(ParamTypes.IDENTIFIER)
                .withParent(PlatformPatterns.psiElement(ParamModeValue::class.java))
                .withLanguage(ParamLanguage.INSTANCE)
        val provider = object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(parameters: CompletionParameters,
                                        context: ProcessingContext,
                                        result: CompletionResultSet) {
                modes.map { LookupElementBuilder.create(it).withIcon(Icons.MYBATIS_LOGO).bold() }
                        .forEach { result.addElement(TailTypeDecorator.withTail(it, TailType.NONE)) }
            }
        }
        extendKeywordCompletion(pattern, provider)
    }

    private fun extendKeywordCompletion(patterns: ElementPattern<out PsiElement>,
                                        provider: CompletionProvider<CompletionParameters>) {
        extend(CompletionType.BASIC, patterns, provider)
    }

    companion object {
        private val keyWords = arrayOf("jdbcType", "javaType", "mode")
        private val modes = arrayOf("IN", "OUT", "INOUT")
        private val jdbcTypes = arrayOf("ARRAY", "BIGINT", "BINARY", "BIT", "BLOB", "BOOLEAN", "CHAR", "CLOB", "CURSOR", "DATALINK", "DATE", "DATETIMEOFFSET", "DECIMAL", "DISTINCT", "DOUBLE", "FLOAT", "INTEGER", "JAVA_OBJECT", "LONGNVARCHAR", "LONGVARBINARY", "LONGVARCHAR", "NCHAR", "NCLOB", "NULL", "NUMERIC", "NVARCHAR", "OTHER", "REAL", "REF", "ROWID", "SMALLINT", "SQLXML", "STRUCT", "TIME", "TIMESTAMP", "TINYINT", "UNDEFINED", "VARBINARY", "VARCHAR")
    }


}
