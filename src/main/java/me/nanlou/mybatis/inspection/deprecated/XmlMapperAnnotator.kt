package me.nanlou.mybatis.inspection.deprecated

import com.intellij.codeInsight.daemon.impl.AnnotationHolderImpl
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.xml.XmlFile
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import me.nanlou.mybatis.utils.MapperUtils
import me.nanlou.mybatis.utils.MyDomManager
import java.util.stream.Collectors


/**
 * @author me
 * @date  2018-08-19 00:34
 */
@Deprecated("")
class XmlMapperAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is XmlFile) {
            return
        }
        if (MapperUtils.isNotMapperXml(element as PsiFile)) {
            return
        }
        holder as AnnotationHolderImpl
        val mapper = MyDomManager.getDomModel(element, Mapper::class.java) ?: return
        checkDuplicateAndExist(mapper, holder)
    }

    /**
     * 检查id
     */
    private fun checkDuplicateAndExist(mapper: Mapper, holder: AnnotationHolderImpl) {
        //curd标签list
        val list = DomUtil.getChildrenOf(mapper, CurdElement::class.java)

        list.filter { it.id.value == null }
                .forEach {
                    holder.createErrorAnnotation(it.id.xmlAttributeValue!!.valueTextRange, "The id: [${it.id.stringValue}] is non-existent")
                }

        //获取重复的id列表
        val mulIds = list.map { it.id.stringValue }.stream()
                //该lambda的作用是,聚合所有相同的key，并将value设为key出现的频率
                .collect(Collectors.toMap<String, String, Int>({ it }, { 1 }, { a, b -> Integer.sum(a, b) }))
                //获取重复id的string值，并合并为list
                .filter { it.value > 1 }.map { it.key }
        list.filter { it.id.stringValue in mulIds }.forEach {
            holder.createErrorAnnotation(it.id.xmlAttributeValue!!.valueTextRange, "There are multiple duplicate id: ${it.id.stringValue}")
        }
    }


}