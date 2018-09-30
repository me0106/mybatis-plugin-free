package me.nanlou.mybatis.service

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.project.Project
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.search.GlobalSearchScope

/**
 * @author me
 */
//todo type alias
class TypeAliasService(val project: Project) {


    fun findAliasPsiClass(name: String): PsiClass? {
        val className = baseTypeMapping[name] ?: return null
        return ServiceManager.getService(JavaPsiFacade::class.java)
                .findClass(className.typeName, GlobalSearchScope.projectScope(project))

    }


    companion object {
        val baseTypeMapping = mapOf<String, Class<*>>(
                "string" to java.lang.String::class.java,
                "byte" to java.lang.Byte::class.java,
                "long" to java.lang.Long::class.java,
                "short" to java.lang.Short::class.java,
                "int" to java.lang.Integer::class.java,
                "integer" to java.lang.Integer::class.java,
                "double" to java.lang.Double::class.java,
                "float" to java.lang.Float::class.java,
                "boolean" to java.lang.Boolean::class.java,
                "map" to Map::class.java,
                "list" to List::class.java
        )

        fun getInstance(project: Project): TypeAliasService {
            return ServiceManager.getService(project, TypeAliasService::class.java)
        }
    }
}