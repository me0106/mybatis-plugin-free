package me.nanlou.mybatis.description

import com.intellij.openapi.module.Module
import com.intellij.psi.xml.XmlFile
import com.intellij.util.xml.DomFileDescription
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.utils.Icons
import me.nanlou.mybatis.utils.MapperUtils

import javax.swing.*

/**
 * @author me
 * @date 2018-08-14 23:54
 */
class MapperDescription : DomFileDescription<Mapper>(Mapper::class.java, rootName) {


    override fun isMyFile(file: XmlFile, module: Module?): Boolean {
        return rootName == file.rootTag?.name
    }

    override fun getFileIcon(flags: Int): Icon {
        return Icons.MAPPER_ICON
    }

    companion object {
        const val rootName = "mapper"
    }
}
