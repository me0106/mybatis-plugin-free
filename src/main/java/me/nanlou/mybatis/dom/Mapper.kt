@file:Suppress("unused")

package me.nanlou.mybatis.dom

import com.intellij.psi.PsiClass
import com.intellij.util.xml.*
import com.intellij.util.xml.DomElement
import me.nanlou.mybatis.dom.sub.*
import me.nanlou.mybatis.dom.sub.curd.Delete
import me.nanlou.mybatis.dom.sub.curd.Insert
import me.nanlou.mybatis.dom.sub.curd.Select
import me.nanlou.mybatis.dom.sub.curd.Update
import me.nanlou.mybatis.dom.sub.resultmap.ResultMap

/**
 *
 * @author me
 */
interface Mapper : DomElement {


    @get:Convert(PsiClassConverter::class)
    val namespace: GenericAttributeValue<PsiClass>

    val cacheRefs: List<CacheRef>

    val caches: List<Cache>


    @get:SubTagList("resultMap")
    val resultMaps: List<ResultMap>


    @get:SubTagList("parameterMap")
    val parameterMaps: List<ParameterMap>


    val sqls: List<Sql>


    val inserts: List<Insert>


    val updates: List<Update>


    val deletes: List<Delete>


    val selects: List<Select>

    fun addCacheRef(): CacheRef


    fun addCache(): Cache


    @SubTagList("resultMap")
    fun addResultMap(): ResultMap


    @SubTagList("parameterMap")
    fun addParameterMap(): ParameterMap


    fun addSql(): Sql


    fun addInsert(): Insert


    fun addUpdate(): Update


    fun addDelete(): Delete


    fun addSelect(): Select


}
