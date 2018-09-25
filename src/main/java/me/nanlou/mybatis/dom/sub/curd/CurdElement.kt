package me.nanlou.mybatis.dom.sub.curd

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.util.xml.*
import me.nanlou.mybatis.converter.PsiMethodConverter
import me.nanlou.mybatis.dom.sub.*

interface CurdElement : DomElement {


    @get:Required
    var value: String


    @get:Convert(PsiMethodConverter::class)
    val id: GenericAttributeValue<PsiMethod>


    val parameterMap: GenericAttributeValue<String>


    val parameterType: GenericAttributeValue<PsiClass>


    val timeout: GenericAttributeValue<String>


    val flushCache: GenericAttributeValue<FlushCache>


    val statementType: GenericAttributeValue<StatementType>


    val databaseId: GenericAttributeValue<String>


    val lang: GenericAttributeValue<String>

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


}