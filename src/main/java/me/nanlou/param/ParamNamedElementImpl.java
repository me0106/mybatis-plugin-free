package me.nanlou.param;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * @author me
 * @date 2018-09-24 22:42
 */
public abstract class ParamNamedElementImpl extends ASTWrapperPsiElement implements ParamNamedElement{
    public ParamNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
