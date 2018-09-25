package me.nanlou.param;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import me.nanlou.param.psi.ParamField;

/**
 * @author me
 * @date 2018-09-24 23:03
 */
public class ParamElementFactory {


    public static ParamField createProperty(Project project, String name) {
        final ParamFile file = createFile(project, name);
        return (ParamField) file.getFirstChild();
    }

    public static ParamFile createFile(Project project, String text) {
        String name = "temp.param";
        return (ParamFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, ParamFileType.INSTANCE, text);
    }
}
