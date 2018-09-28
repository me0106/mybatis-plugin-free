package me.nanlou.mybatis.converter.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author me
 * @date 2018-09-27 00:49
 */
public class MethodReference extends PsiReferenceBase<PsiMethod> {
    public MethodReference(@NotNull PsiMethod element) {
        super(element);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return myElement;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }
}
