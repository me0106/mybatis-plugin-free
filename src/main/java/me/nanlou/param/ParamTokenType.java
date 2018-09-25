package me.nanlou.param;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author me
 * @date 2018-09-23 00:06
 */
public class ParamTokenType extends IElementType {
    public ParamTokenType(@NotNull String debugName) {
        super(debugName, ParamLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "ParamTokenType." + super.toString();
    }
}
