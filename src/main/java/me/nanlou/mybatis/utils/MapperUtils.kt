package me.nanlou.mybatis.utils

import com.intellij.psi.PsiFile
import com.intellij.psi.xml.XmlFile

/**
 * @author me
 * @date 2018-08-18 11:39
 */
object MapperUtils {

    val sqlNames = arrayOf("insert", "delete", "update", "select")

    fun isMapperXml(psiFile: PsiFile): Boolean {
        if (psiFile !is XmlFile) {
            return false
        }
        return psiFile.rootTag?.name == "mapper"
    }
}
