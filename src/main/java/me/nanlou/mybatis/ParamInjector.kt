package me.nanlou.mybatis

import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.xml.XmlFile
import com.intellij.psi.xml.XmlTag
import com.intellij.psi.xml.XmlText
import com.intellij.sql.psi.SqlLanguage
import com.intellij.util.xml.DomUtil
import io.netty.util.internal.StringUtil
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import me.nanlou.mybatis.utils.MapperUtils
import me.nanlou.param.ParamLanguage
import org.jf.util.StringUtils
import java.util.regex.Pattern

/**
 *
 * ParamLanguage Inject
 * @author me
 * @date 2018-09-24 16:47
 */
class ParamInjector : MultiHostInjector, DumbAware {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        if (!supportInjectSql(context)) {
            return
        }
        injectSql(registrar, context)
    }

    /**
     * 检查是否可以注入sql，
     */
    private fun supportInjectSql(context: PsiElement): Boolean {
        val file = context.containingFile
        if (MapperUtils.isNotMapperXml(file)) {
            return false
        }
        if (context !is XmlText) {
            return false
        }
        val psi = PsiTreeUtil.getParentOfType(context, XmlTag::class.java, true)
        DomUtil.getDomElement(psi)as? CurdElement ?: return false
        return true
    }

    /**
     * 进行注入
     */
    private fun injectSql(registrar: MultiHostRegistrar, context: PsiElement) {
        val range = TextRange.create(0, context.textLength)
        registrar.startInjecting(SqlLanguage.INSTANCE)
                .addPlace(null, null, context as PsiLanguageInjectionHost, range)
        registrar.doneInjecting()
        context as XmlText
        val list = getPattern((context as XmlText).text)
        list.forEach {
            registrar.startInjecting(ParamLanguage.INSTANCE)
                    .addPlace(null, null, context as PsiLanguageInjectionHost, it)
            registrar.doneInjecting()
        }
    }

    /**
     * 获取匹配的 ${}/#{}位置，进行paramLanguage注入
     */
    private fun getPattern(str: String): List<TextRange> {
        val matcher = pattern.matcher(str)
        val list = ArrayList<TextRange>()
        var start = 0
        while (matcher.find()) {
            val target = matcher.group()
            start = str.indexOf(target, start)
            list.add(TextRange.create(start, start + target.length))
            start += target.length
        }
        return list

    }

    companion object {
        val pattern = Pattern.compile("[#$]\\{.*?}")!!
    }


    override fun elementsToInjectIn(): List<Class<out PsiElement>> {
        return listOf(PsiElement::class.java)
    }
}