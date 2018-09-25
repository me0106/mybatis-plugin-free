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
//        判断是否初始化
        if (cache.isEmpty()) {
            initMapper(project)
        }
//        查找class对应的Mapper
        var mapper = cache[psiClass]

//        没有就全局找
        if (mapper == null) {
            mapper = findElement(psiClass, project)
        }
//        如果还是没有，那就return null
        if (mapper == null) {
            return null
        }
//        如果全局有Mapper，那就删掉Mapper在cache内的关联，再把Mapper和当前Class进行关联(Class->Mapper)
        cache.remove(cache.entries.find { it.value == mapper }?.key)
        cache[psiClass] = mapper
        return mapper
    }


    private fun initMapper(project: Project) {
        val scope = GlobalSearchScope.projectScope(project)
        //获取项目中所有的Mapper.xml，(XmlFile类型)
        val list = ServiceManager.getService(DomService::class.java)
                .getFileElements(Mapper::class.java, project, scope)
        list.forEach { cache[it.rootElement.namespace.value] = it.rootElement }
        cache[null] = null
    }


    private fun findElement(psiClass: PsiClass?, project: Project): Mapper? {
        val scope = GlobalSearchScope.projectScope(project)
        return ServiceManager.getService(DomService::class.java)
                .getFileElements(Mapper::class.java, project, scope)
                .find { it.rootElement.namespace.value == psiClass }?.rootElement
    }
}
