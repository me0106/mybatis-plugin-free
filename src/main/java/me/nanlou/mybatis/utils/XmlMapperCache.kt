package me.nanlou.mybatis.utils

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiClass
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.xml.DomService
import me.nanlou.mybatis.dom.Mapper
import java.util.*

/**
 * @author me
 * @date 2018-08-14 21:47
 */
object XmlMapperCache {
    private val cache = LinkedHashMap<PsiClass?, Mapper?>()

    fun findMapper(psiClass: PsiClass?, project: Project): Mapper? {
        if (psiClass == null) {
            return null
        }
        if (cache.isEmpty()) {
            initMapper(project)
        }
        var mapper = cache[psiClass]
        if (mapper == null) {
            mapper = findElement(psiClass, project)
        }
        if (mapper == null) {
            return null
        }
        cache.remove(cache.entries.find { it.value == mapper }?.key)
        cache[psiClass] = mapper
        return mapper
    }


    private fun initMapper(project: Project) {
        val scope = GlobalSearchScope.projectScope(project)
        //获取项目中所有的Mapper.xml，(XmlFile类型)
        val list = ServiceManager.getService(DomService::class.java).getFileElements(Mapper::class.java, project, scope)
        list.forEach { cache[it.rootElement.namespace.value] = it.rootElement }
        cache[null] = null
    }


    private fun findElement(psiClass: PsiClass?, project: Project): Mapper? {
        val scope = GlobalSearchScope.projectScope(project)
        return ServiceManager.getService(DomService::class.java)
                .getFileElements(Mapper::class.java, project, scope)
                .firstOrNull { it.rootElement.namespace.value == psiClass }?.rootElement
    }
}
