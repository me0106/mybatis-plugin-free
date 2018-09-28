package me.nanlou.mybatis.inspection.check

import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.openapi.util.TextRange
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import java.util.stream.Collectors

@Suppress("UNUSED_PARAMETER")
/**
 *
 * 公共部分检查
 * @author me
 * @date 2018-09-26 14:34
 */
class PublicElementChecker : XmlChecker {
    override fun check(mapper: Mapper, manager: InspectionManager): List<ProblemDescriptor> {
        return doCheck(mapper, manager)
    }

    private fun doCheck(mapper: Mapper, manager: InspectionManager): List<ProblemDescriptor> {
        //curd标签list
        val list = DomUtil.getChildrenOf(mapper, CurdElement::class.java)
        val errList = arrayListOf<ProblemDescriptor>()
        errList.addAll(notExistIdCheck(manager, list))
        //获取重复的id
        errList.addAll(duplicateIdCheck(manager, list))
        errList.addAll(parameterMapCheck(manager, list))
        errList.addAll(parameterTypeCheck(manager, list))
        errList.addAll(resultMapCheck(manager, list))
        errList.addAll(resultTypeCheck(manager, list))
        return errList
    }

    //id  不存在检查
    private fun notExistIdCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return elements.asSequence().filter { it.id.value == null }.map { it.id.xmlAttributeValue }
                .map { manager.createProblemDescriptor(it!!, TextRange(1, it.textLength - 1), "Unresolved method name:[${it.value}]", ProblemHighlightType.ERROR, true, *LocalQuickFix.EMPTY_ARRAY) }
                .toList()
    }


    //id  重复id检查
    private fun duplicateIdCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        val mulIds = elements.map { it.id.stringValue }.stream()
                //该lambda的作用是,聚合所有相同的key，并将value设为key出现的频率
                .collect(Collectors.toMap<String, String, Int>({ it }, { 1 }, { a, b -> Integer.sum(a, b) }))
                //获取重复id的string值，并合并为list
                .filter { it.value > 1 }.map { it.key }
        return elements.asSequence().filter { it.id.stringValue in mulIds }.map { it.id.xmlAttributeValue }
                .map { manager.createProblemDescriptor(it!!, TextRange(1, it.textLength - 1), "There are multiple duplicate id: ${it.value}", ProblemHighlightType.GENERIC_ERROR, true, *LocalQuickFix.EMPTY_ARRAY) }
                .toList()
    }

    //todo
    private fun parameterMapCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return emptyList()
    }

    private fun parameterTypeCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return emptyList()
    }

    private fun resultMapCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return emptyList()
    }

    private fun resultTypeCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return emptyList()
    }
}
