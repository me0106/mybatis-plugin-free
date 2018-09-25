package me.nanlou.mybatis.utils

import com.intellij.psi.xml.XmlFile
import com.intellij.util.xml.DomElement
import com.intellij.util.xml.DomManager

object MyDomManager {

    fun <T : DomElement> getDomModel(xmlFile: XmlFile, clazz: Class<T>): T? {
        return DomManager.getDomManager(xmlFile.project).getFileElement(xmlFile, clazz)?.rootElement
    }


}