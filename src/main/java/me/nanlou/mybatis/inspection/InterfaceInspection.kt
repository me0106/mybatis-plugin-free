package me.nanlou.mybatis.inspection

import com.intellij.codeInspection.*
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiJavaFile
import com.intellij.psi.PsiMethod
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import me.nanlou.mybatis.service.XmlMapperService
import org.jetbrains.kotlin.idea.refactoring.isInterfaceClass

/**
 * @author me
 * @date 2018-09-26 14:21
 */
class InterfaceInspection : LocalInspectionTool() {


    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor>? {
        if (file !is PsiJavaFile) {
            return ProblemDescriptor.EMPTY_ARRAY
        }
        if (file.classes.isEmpty()) {
            return ProblemDescriptor.EMPTY_ARRAY
        }
        return doCheck(file.classes[0], manager).toTypedArray()
    }


    //todo
    private fun doCheck(clazz: PsiClass, manager: InspectionManager): List<ProblemDescriptor> {
        val mappers = XmlMapperService.getInstance(clazz.project).findMappers(clazz.project)
        val mapper = mappers.find { it.rootElement.namespace.value == clazz }?.rootElement ?: return emptyList()
        //找出xml里面所有的方法名
        val xmlMethods = DomUtil.getChildrenOf(mapper, CurdElement::class.java).map { it.id.value }
        //如果方法名不存在于xml，就提示错误
        return clazz.methods.filter { it !in xmlMethods }.map { build(it, manager) }
    }


    private fun build(psiMethod: PsiMethod, manager: InspectionManager): ProblemDescriptor {
        val name = psiMethod.nameIdentifier!!
       return manager.createProblemDescriptor(name,
                TextRange(0, name.textLength),
                "Unresolved Sql Statement: ${name.text} ",
                ProblemHighlightType.GENERIC_ERROR,
                true,
                *LocalQuickFix.EMPTY_ARRAY)
    }


}
