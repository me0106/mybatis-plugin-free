package me.nanlou.mybatis.utils;

import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;

/**
 * @author me
 * @date 2018-08-15 01:02
 */
public class JavaUtils {


    public static PsiClass findPsiClass(String name, Project project) {
        return JavaPsiFacade.getInstance(project).findClass(name, GlobalSearchScope.projectScope(project));
    }
}
