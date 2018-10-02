package me.nanlou.mybatis.dom.sub.curd

// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*
import me.nanlou.mybatis.dom.sub.*

/**
 * null:updateElemType interface.
 *
 * @author me
 */
interface Update : CurdElement {



    @get:SubTagList("selectKey")
    val selectKeys: List<SelectKey>





    @SubTagList("selectKey")
    fun addSelectKey(): SelectKey



}
