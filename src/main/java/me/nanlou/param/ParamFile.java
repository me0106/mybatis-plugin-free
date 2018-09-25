package me.nanlou.param;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author me
 * @date 2018-09-23 01:44
 */
public class ParamFile extends PsiFileBase {
    public ParamFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ParamLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ParamFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Param File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
