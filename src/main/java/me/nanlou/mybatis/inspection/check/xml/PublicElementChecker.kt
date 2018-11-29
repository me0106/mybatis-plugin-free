package me.nanlou.mybatis.inspection.check.xml

import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.openapi.util.TextRange
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import me.nanlou.mybatis.dom.sub.curd.Select
import me.nanlou.mybatis.dom.sub.resultmap.ResultMap
import java.util.stream.Collectors

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

        errList.addAll(namespaceCheck(mapper, manager))
        errList.addAll(notExistIdCheck(manager, list))
        //获取重复的id
        errList.addAll(duplicateIdCheck(manager, list))
        errList.addAll(parameterMapCheck(manager, list))
        errList.addAll(parameterTypeCheck(manager, list))
        errList.addAll(resultMapCheck(manager, mapper))
        errList.addAll(resultTypeCheck(manager, list))
        return errList
    }


    private fun namespaceCheck(mapper: Mapper, manager: InspectionManager): List<ProblemDescriptor> {
        if (mapper.namespace.xmlAttribute == null) {
            return listOf(manager.createProblemDescriptor(mapper.xmlElement!!,
                    create(1, mapper.xmlElement!!.text.length - 1),
                    "require attribute [namespace]",
                    ProblemHighlightType.GENERIC_ERROR,
                    true,
                    *LocalQuickFix.EMPTY_ARRAY))
        }
        val text = mapper.namespace.xmlAttributeValue?.text.orEmpty()
        if (mapper.namespace.value == null) {
            return listOf(manager.createProblemDescriptor(mapper.namespace.xmlAttributeValue!!,
                    create(1, text.length - 1),
                    "Unresolved class:[$text]",
                    ProblemHighlightType.ERROR,
                    true,
                    *LocalQuickFix.EMPTY_ARRAY))
        }
        return emptyList()
    }

    //id  不存在检查
    private fun notExistIdCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return elements.asSequence()
                .filter { it.id.value == null }
                .map { it.id.xmlAttributeValue }
                .filter { it != null }
                .map {
                    manager.createProblemDescriptor(it!!,
                            create(1, it.textLength - 1),
                            "Unresolved method name:[${it.value}]",
                            ProblemHighlightType.ERROR,
                            true,
                            *LocalQuickFix.EMPTY_ARRAY)
                }
                .toList()
    }

    /**
     * TextRange create with check
     */
    val create = { start: Int, end: Int ->
        if (start - end < 0) {
            TextRange(start, end)
        } else {
            TextRange(0, 0)
        }
    }


    //id  重复id检查
    private fun duplicateIdCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        val mulIds = elements.map { it.id.stringValue }.stream()
                //该lambda的作用是,聚合所有相同的key，并将value设为key出现的频率
                .collect(Collectors.toMap<String, String, Int>({ it }, { 1 }, { a, b -> Integer.sum(a, b) }))
                //获取重复id的string值，并合并为list
                .filter { it.value > 1 }.map { it.key }
        return elements.asSequence().filter { it.id.stringValue in mulIds }.map { it.id.xmlAttributeValue }
                .map { manager.createProblemDescriptor(it!!, create(1, it.textLength - 1), "There are multiple duplicate id: ${it.value}", ProblemHighlightType.GENERIC_ERROR, true, *LocalQuickFix.EMPTY_ARRAY) }
                .toList()
    }

    //todo
    private fun parameterMapCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return emptyList()
    }

    private fun parameterTypeCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return elements.asSequence().filter { it.parameterType.value == null }
                .map { it.parameterType.xmlAttribute }
                .filter { it != null }
                .map {
                    manager.createProblemDescriptor(it!!,
                            create(1, it.textLength - 1),
                            "Unresolved method name:[${it.value}]",
                            ProblemHighlightType.ERROR,
                            true,
                            *LocalQuickFix.EMPTY_ARRAY)
                }.toList()


    }

    private fun resultMapCheck(manager: InspectionManager, mapper: Mapper): List<ProblemDescriptor> {
        val selects = DomUtil.getChildrenOf(mapper, Select::class.java)
        val resultMaps = DomUtil.getChildrenOf(mapper, ResultMap::class.java)
                .map { it.xmlTag }
        return selects.asSequence()
                .filter { it.resultMap.value !in resultMaps }
                .map { it.resultMap.xmlAttributeValue }
                .filter { it != null }
                .map {
                    manager.createProblemDescriptor(it!!,
                            create(1, it.textLength - 1),
                            "Unresolved resultMap :[${it.value}]",
                            ProblemHighlightType.ERROR,
                            true,
                            *LocalQuickFix.EMPTY_ARRAY)
                }.toList()
    }

    private fun resultTypeCheck(manager: InspectionManager, elements: List<CurdElement>): List<ProblemDescriptor> {
        return emptyList()
    }
}
