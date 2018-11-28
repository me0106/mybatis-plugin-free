package me.nanlou.param.contributor

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import me.nanlou.param.ParamLanguage
import me.nanlou.param.psi.ParamField
import me.nanlou.param.psi.ParamTypes

/**
 * @author me
 * @date 2018-10-13 12:23
 */
class ParamReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        val pattern = PlatformPatterns.psiElement()
                .withLanguage(ParamLanguage.INSTANCE)
        registrar.registerReferenceProvider(pattern, Provider())
    }


    private class Provider : PsiReferenceProvider() {

        override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            println(element)
            return emptyArray()
        }
    }

    private class MyReference(element: ParamField) : PsiReferenceBase<ParamField>(element) {

        override fun resolve(): PsiElement? {
            return null
        }

        override fun getVariants(): Array<Any> {
            return emptyArray()
        }
    }
}
