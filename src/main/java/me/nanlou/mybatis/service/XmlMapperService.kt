package me.nanlou.mybatis.service

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.xml.DomFileElement
import com.intellij.util.xml.DomService
import me.nanlou.mybatis.dom.Mapper

/**
 * @author me
 */
class XmlMapperService(val project: Project) {


    fun findMappers(project: Project): List<DomFileElement<Mapper>> {
        val scope = GlobalSearchScope.projectScope(project)
        return ServiceManager.getService(DomService::class.java)
                .getFileElements(Mapper::class.java, project, scope)
    }

    fun isMybatisInterface(psiClass: PsiClass): Boolean {
        return findMappers(project)
                .asSequence()
                .map { it.rootElement }
                .filter { it.namespace.value == psiClass }
                .toList().isNotEmpty()
    }


    companion object {

        fun getInstance(project: Project): XmlMapperService {
            return ServiceManager.getService(project, XmlMapperService::class.java)
        }
    }


}
