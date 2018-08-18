package me.nanlou.mybatis.dom.sub.curd

// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.psi.PsiMethod
import com.intellij.util.xml.*
import com.intellij.util.xml.DomElement
import me.nanlou.mybatis.dom.sub.*

/**
 * null:selectElemType interface.
 * @author me
 */
interface Select : SqlElement {


/*    @get:Required
    var value: String


    @get:Required
    val id: GenericAttributeValue<PsiMethod>


    val parameterMap: GenericAttributeValue<String>


    val parameterType: GenericAttributeValue<String>*/

    val resultMap: GenericAttributeValue<String>

    val resultType: GenericAttributeValue<String>

    val resultSetType: GenericAttributeValue<ResultSetType>
/*

    val statementType: GenericAttributeValue<StatementType>


    val fetchSize: GenericAttributeValue<String>

    val timeout: GenericAttributeValue<String>


    val flushCache: GenericAttributeValue<FlushCache>


    val useCache: GenericAttributeValue<UseCache>


    val databaseId: GenericAttributeValue<String>

    val lang: GenericAttributeValue<String>*/

    val resultOrdered: GenericAttributeValue<ResultOrdered>

    val resultSets: GenericAttributeValue<String>
/*

    val includes: List<Include>

    val trims: List<Trim>


    val wheres: List<GenericDomValue<String>>


    val sets: List<GenericDomValue<String>>


    val foreaches: List<Foreach>


    val chooses: List<Choose>


    val ifs: List<If>


    val binds: List<Bind>

    fun addInclude(): Include


    fun addTrim(): Trim


    fun addWhere(): GenericDomValue<String>


    fun addSet(): GenericDomValue<String>


    fun addForeach(): Foreach


    fun addChoose(): Choose


    fun addIf(): If

    fun addBind(): Bind
*/


}
