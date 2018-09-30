package me.nanlou.mybatis.inspection

import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.psi.PsiFile
import com.intellij.psi.xml.XmlFile
import me.nanlou.mybatis.inspection.check.xml.PublicElementChecker
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.utils.MapperUtils
import me.nanlou.mybatis.utils.MyDomManager

/**
 * @author me
 * @date 2018-09-26 13:27
 */
class XmlMapperInspection : LocalInspectionTool() {

    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor>? {
        if (MapperUtils.isNotMapperXml(file)) {
            return ProblemDescriptor.EMPTY_ARRAY
        }
        val list = arrayListOf<ProblemDescriptor>()
        val mapper = MyDomManager.getDomModel(file as XmlFile, Mapper::class.java) ?: return emptyArray()
        list.addAll(PublicElementChecker().check(mapper, manager))
        return list.toTypedArray()
    }


}
