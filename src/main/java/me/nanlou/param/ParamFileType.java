package me.nanlou.param;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author me
 * @date 2018-09-23 00:02
 */
public class ParamFileType extends LanguageFileType {

    public static final ParamFileType INSTANCE = new ParamFileType();

    private ParamFileType() {
        super(ParamLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "param file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "param file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "param";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }
}
