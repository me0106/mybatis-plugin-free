package me.nanlou.mybatis.service;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.xml.DomFileElement;
import com.intellij.util.xml.DomService;
import me.nanlou.mybatis.dom.Mapper;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author me
 */
public class XmlMapperService {


    public XmlMapperService(Project project) {
    }

    public static XmlMapperService getInstance(@NotNull Project project) {
        return ServiceManager.getService(project, XmlMapperService.class);
    }


    public List<DomFileElement<Mapper>> findMappers(Project project) {
        GlobalSearchScope scope = GlobalSearchScope.projectScope(project);
        return ServiceManager.getService(DomService.class)
                .getFileElements(Mapper.class, project, scope);
    }


}
