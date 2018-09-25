package me.nanlou.mybatis.converter

import com.intellij.psi.PsiClass
import com.intellij.util.xml.ConvertContext
import com.intellij.util.xml.Converter


/**
 * @author me
 * @date  2018-08-16 09:54
 */
class TypeAliasConverter : Converter<PsiClass>() {
    override fun fromString(s: String?, context: ConvertContext?): PsiClass? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(t: PsiClass?, context: ConvertContext?): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}