package me.nanlou.param.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.injected.editor.EditorWindow
import com.intellij.lang.injection.InjectedLanguageManager
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.xml.XmlElement
import com.intellij.psi.xml.XmlFile
import com.intellij.util.ProcessingContext
import me.nanlou.mybatis.utils.findSqlParamNameMap
import me.nanlou.mybatis.utils.findXmlTag
import me.nanlou.param.ParamLanguage
import me.nanlou.param.psi.ParamField
import me.nanlou.param.psi.ParamTypes
import javax.swing.Icon

/**
 * @author me
 * @date 2018-09-24 23:38
 */
class ParamCompletionContributor : CompletionContributor() {
    init {
        init()
    }
    private fun init() {
        val pattern = PlatformPatterns.psiElement(ParamTypes.IDENTIFIER)
                .withParent(PlatformPatterns.psiElement(ParamField::class.java))
                .withLanguage(ParamLanguage.INSTANCE)
        extend(CompletionType.BASIC, pattern, Provider())
    }


    private class Provider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val project = parameters.position.project
            if (parameters.editor !is EditorWindow) {
                return
            }
            //当前鼠标指针在整个文本的偏移量
            val offset = (parameters.editor as EditorWindow).delegate.caretModel.offset
            //当前编辑的Mapper.xml
            val file = InjectedLanguageManager.getInstance(project).getTopLevelFile(parameters.position) as XmlFile
            //查找偏移量对应的xmlElement,
            val e = file.findElementAt(offset) as? XmlElement
            e?.findXmlTag()?.findSqlParamNameMap()?.forEach { t, u -> result.addElement(builder(t, u)) }
        }

        private fun builder(name: String?, icon: Icon): LookupElementBuilder {
            return LookupElementBuilder.create(name!!).bold().withIcon(icon).withCaseSensitivity(false)
        }
    }
}
