package me.nanlou.mybatis.dom.sub.curd

// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.psi.PsiMethod
import com.intellij.util.xml.*
import com.intellij.util.xml.DomElement
import me.nanlou.mybatis.dom.sub.*

/**
 * null:updateElemType interface.
 *
 * @author me
 */
interface Update : SqlElement {

//    @get:Required
//    var value: String
//
//
//    @get:Required
//    val id: GenericAttributeValue<PsiMethod>
//
//
//    val parameterMap: GenericAttributeValue<String>
//
//
//    val parameterType: GenericAttributeValue<String>
//
//    val timeout: GenericAttributeValue<String>
//
//
//    val flushCache: GenericAttributeValue<FlushCache>
//
//
//    val statementType: GenericAttributeValue<StatementType>
//
//    val keyProperty: GenericAttributeValue<String>
//
//    val useGeneratedKeys: GenericAttributeValue<UseGeneratedKeys>
//
//
//    val keyColumn: GenericAttributeValue<String>
//
//
//    val databaseId: GenericAttributeValue<String>
//
//
//    val lang: GenericAttributeValue<String>


    @get:SubTagList("selectKey")
    val selectKeys: List<SelectKey>


//    val includes: List<Include>
//
//
//    val trims: List<Trim>
//
//
//    val wheres: List<GenericDomValue<String>>


//    val sets: List<GenericDomValue<String>>

//
//    val foreaches: List<Foreach>
//
//
//    val chooses: List<Choose>
//
//
//    val ifs: List<If>
//
//
//    val binds: List<Bind>


    @SubTagList("selectKey")
    fun addSelectKey(): SelectKey

//
//    fun addInclude(): Include
//
//
//    fun addTrim(): Trim
//
//
//    fun addWhere(): GenericDomValue<String>
//
//
//    fun addSet(): GenericDomValue<String>
//
//
//    fun addForeach(): Foreach
//
//
//    fun addChoose(): Choose
//
//
//    fun addIf(): If
//
//    fun addBind(): Bind


}
