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
import java.util.stream.Collectors

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
        return file.classes.filter { XmlMapperService.getInstance(it.project).isMybatisInterface(it) }
                .flatMap { doCheck(it, manager) }.toTypedArray()
    }


    private fun doCheck(clazz: PsiClass, manager: InspectionManager): List<ProblemDescriptor> {
        val list = ArrayList<ProblemDescriptor>()
        list.addAll(notExistIdCheck(clazz, manager))
        list.addAll(duplicateIdCheck(clazz, manager))
        return list
    }


    //检索在映射文件里面不存在的方法
    private fun notExistIdCheck(clazz: PsiClass, manager: InspectionManager): List<ProblemDescriptor> {
        val mappers = XmlMapperService.getInstance(clazz.project).findMappers(clazz.project).map { it.rootElement }
        //找出xml里面所有的方法名
        val xmlMethods = mappers.flatMap { DomUtil.getChildrenOf(it, CurdElement::class.java) }
                .map { it.id.value?.name }
        //如果方法名不存在于xml，就提示错误
        return clazz.methods.filter { it.name !in xmlMethods }.map { notExistBuilder(it, manager) }

    }

    //接口方法 不允许重载
    private fun duplicateIdCheck(clazz: PsiClass, manager: InspectionManager): List<ProblemDescriptor> {
        val methods = clazz.methods.map { it.name }.stream()
                //该lambda的作用是,聚合所有相同的key，并将value设为key出现的频率
                .collect(Collectors.toMap<String, String, Int>({ it }, { 1 }, { a, b -> Integer.sum(a, b) }))
                .filter { it.value > 1 }.map { it.key }
        return clazz.methods.filter { it.name in methods }.map { duplicateBuilder(it, manager) }
    }


    private fun duplicateBuilder(psiMethod: PsiMethod, manager: InspectionManager): ProblemDescriptor {
        val name = psiMethod.nameIdentifier!!
        return manager.createProblemDescriptor(name,
                TextRange(0, name.textLength),
                "Mybatis interface method does not allow overload",
                ProblemHighlightType.ERROR,
                true,
                *LocalQuickFix.EMPTY_ARRAY)
    }

    private fun notExistBuilder(psiMethod: PsiMethod, manager: InspectionManager): ProblemDescriptor {
        val name = psiMethod.nameIdentifier!!
        return manager.createProblemDescriptor(name,
                TextRange(0, name.textLength),
                "Unresolved Sql Statement: ${name.text} ",
                ProblemHighlightType.GENERIC_ERROR,
                true,
                *LocalQuickFix.EMPTY_ARRAY)
    }


}
