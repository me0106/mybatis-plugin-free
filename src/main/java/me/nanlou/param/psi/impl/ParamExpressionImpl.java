// This is a generated file. Not intended for manual editing.
package me.nanlou.param.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static me.nanlou.param.psi.ParamTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import me.nanlou.param.psi.*;
import me.nanlou.param.ParamPsiImplUtil;

public class ParamExpressionImpl extends ASTWrapperPsiElement implements ParamExpression {

  public ParamExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ParamVisitor visitor) {
    visitor.visitExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ParamVisitor) accept((ParamVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ParamJavaTypeExpression getJavaTypeExpression() {
    return findChildByClass(ParamJavaTypeExpression.class);
  }

  @Override
  @Nullable
  public ParamJdbcTypeExpression getJdbcTypeExpression() {
    return findChildByClass(ParamJdbcTypeExpression.class);
  }

  @Override
  @Nullable
  public ParamModeExpression getModeExpression() {
    return findChildByClass(ParamModeExpression.class);
  }

  @Override
  @NotNull
  public ParamVarExpression getVarExpression() {
    return findNotNullChildByClass(ParamVarExpression.class);
  }

}
