// This is a generated file. Not intended for manual editing.
package me.nanlou.param.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ParamExpression extends PsiElement {

  @NotNull
  List<ParamJavaTypeExpression> getJavaTypeExpressionList();

  @NotNull
  List<ParamJdbcTypeExpression> getJdbcTypeExpressionList();

  @NotNull
  List<ParamModeExpression> getModeExpressionList();

  @NotNull
  ParamVarExpression getVarExpression();

}
