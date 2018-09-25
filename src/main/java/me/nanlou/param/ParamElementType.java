package me.nanlou.param;

import com.intellij.lang.Language;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author me
 * @date 2018-09-23 00:07
 */
public class ParamElementType extends IElementType {
    public ParamElementType(@NotNull String debugName) {
        super(debugName, ParamLanguage.INSTANCE);
    }

}
