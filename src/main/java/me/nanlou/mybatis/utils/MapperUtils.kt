package me.nanlou.mybatis.utils

import com.intellij.psi.PsiFile
import com.intellij.psi.xml.XmlFile
import me.nanlou.mybatis.description.MapperDescription

/**
 * @author me
 * @date 2018-08-18 11:39
 */
object MapperUtils {

    fun isMapperXml(psiFile: PsiFile): Boolean {
        if (psiFile !is XmlFile) {
            return false
        }
        return psiFile.rootTag?.name == MapperDescription.rootName
    }


    fun isNotMapperXml(psiFile: PsiFile): Boolean {
        return !isMapperXml(psiFile)
    }
}
