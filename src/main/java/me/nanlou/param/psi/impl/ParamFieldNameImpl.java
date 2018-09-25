// This is a generated file. Not intended for manual editing.
package me.nanlou.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static me.nanlou.param.psi.ParamTypes.*;
import me.nanlou.param.ParamNamedElementImpl;
import me.nanlou.param.psi.*;
import me.nanlou.param.ParamPsiImplUtil;

public class ParamFieldNameImpl extends ParamNamedElementImpl implements ParamFieldName {

  public ParamFieldNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamVisitor visitor) {
    visitor.visitFieldName(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParamVisitor) accept((ParamVisitor)visitor);
    else super.accept(visitor);
  }

  public String getKey() {
    return ParamPsiImplUtil.getKey(this);
  }

  public String getName() {
    return ParamPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return ParamPsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return ParamPsiImplUtil.getNameIdentifier(this);
  }

}
