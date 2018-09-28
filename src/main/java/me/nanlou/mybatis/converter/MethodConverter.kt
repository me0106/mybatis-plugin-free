package me.nanlou.mybatis.converter

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.psi.scope.processor.MethodResolveProcessor
import com.intellij.spring.model.converters.PsiMethodConverter
import com.intellij.util.xml.*
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.utils.MyDomManager
import java.util.stream.Stream


/**
 * @author me
 * @date  2018-08-16 09:53
 */
//class MethodConverter : Converter<PsiMethod>(), CustomReferenceConverter<PsiMethod> {
open class MethodConverter : PsiMethodConverter() {
    override fun getMethodCandidates(p0: String?, p1: PsiClass?): Array<PsiMethod> {
        return MethodResolveProcessor.findMethod(p1, p0)
    }

    override fun getMethodIdentificator(p0: PsiMethod?): String {
        return p0.toString()
    }

    override fun getPsiClass(p0: ConvertContext?): PsiClass? {
        val mapper = MyDomManager.getDomModel(p0?.file, Mapper::class.java)
        return mapper?.namespace?.value
    }


    override fun toString(t: PsiMethod?, context: ConvertContext?): String? {
        return t.toString()
    }

    override fun fromString(s: String?, context: ConvertContext?): PsiMethod? {

        val mapper = MyDomManager.getDomModel(context!!.file, Mapper::class.java) ?: return null
        return mapper.namespace.value?.findMethodsByName(s, false)?.getOrNull(0)
    }


}