package me.nanlou.mybatis.annotator

import com.intellij.codeInsight.daemon.impl.AnnotationHolderImpl
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
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
class XmlMapperAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is XmlFile) {
            return
        }
        if (MapperUtils.isNotMapperXml(element.containingFile)) {
            return
        }
        holder as AnnotationHolderImpl
        val mapper = MyDomManager.getDomModel(element, Mapper::class.java) ?: return
        checkDuplicateId(mapper, holder)
    }

    /**
     * 检查id重复
     */
    private fun checkDuplicateId(mapper: Mapper, holder: AnnotationHolderImpl) {
        //curd标签list
        val list = DomUtil.getChildrenOf(mapper, CurdElement::class.java)
        //获取重复的id
        val mulIds = list.map { it.id.stringValue }.stream()
                //该lambda的作用是,聚合所有相同的key，并将value设为key出现的频率
                .collect(Collectors.toMap<String, String, Int>({ it }, { 1 }, { a, b -> Integer.sum(a, b) }))
                //获取重复id的string值，并合并为list
                .filter { it.value > 1 }.map { it.key }
        list.filter {
            it.id.stringValue in mulIds
        }.forEach {
            holder.createErrorAnnotation(it.id.xmlAttributeValue!!, "There are multiple duplicate id: ${it.id.stringValue}")
        }
    }
}