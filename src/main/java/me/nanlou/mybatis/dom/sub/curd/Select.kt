package me.nanlou.mybatis.dom.sub.curd

// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.psi.PsiClass
import com.intellij.psi.xml.XmlTag
import com.intellij.util.xml.*
import me.nanlou.mybatis.converter.ResultMapConverter
import me.nanlou.mybatis.dom.sub.ResultOrdered
import me.nanlou.mybatis.dom.sub.ResultSetType

/**
 * null:selectElemType interface.
 * @author me
 */
interface Select : CurdElement, DomElement {


    @get:Convert(ResultMapConverter::class)
    @get:Attribute("resultMap")
    val resultMap: GenericAttributeValue<XmlTag>


    @get:Convert(PsiClassConverter::class)
    val resultType:GenericAttributeValue<PsiClass>

    val resultSetType: GenericAttributeValue<ResultSetType>


    val resultOrdered: GenericAttributeValue<ResultOrdered>

    val resultSets: GenericAttributeValue<String>


}
