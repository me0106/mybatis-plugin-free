package me.nanlou.mybatis.description

import com.intellij.openapi.module.Module
import com.intellij.psi.xml.XmlFile
import com.intellij.util.xml.DomFileDescription
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.utils.Icons

import javax.swing.*

/**
 * @author me
 * @date 2018-08-14 23:54
 */
class MapperDescription : DomFileDescription<Mapper>(Mapper::class.java, "mapper") {


    override fun isMyFile(file: XmlFile, module: Module?): Boolean {
        return "mapper" == file.rootTag?.name
    }

    override fun getFileIcon(flags: Int): Icon? {
        return Icons.MAPPER_ICON
    }
}
