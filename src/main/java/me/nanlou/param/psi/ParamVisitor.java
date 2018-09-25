// This is a generated file. Not intended for manual editing.
package me.nanlou.param.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import me.nanlou.param.ParamNamedElement;

public class ParamVisitor extends PsiElementVisitor {

  public void visitClassName(@NotNull ParamClassName o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull ParamExpression o) {
    visitPsiElement(o);
  }

  public void visitField(@NotNull ParamField o) {
    visitNamedElement(o);
  }

  public void visitJavaTypeExpression(@NotNull ParamJavaTypeExpression o) {
    visitPsiElement(o);
  }

  public void visitJavaTypeValue(@NotNull ParamJavaTypeValue o) {
    visitPsiElement(o);
  }

  public void visitJdbcTypeExpression(@NotNull ParamJdbcTypeExpression o) {
    visitPsiElement(o);
  }

  public void visitJdbcTypeValue(@NotNull ParamJdbcTypeValue o) {
    visitPsiElement(o);
  }

  public void visitMethod(@NotNull ParamMethod o) {
    visitPsiElement(o);
  }

  public void visitMethodName(@NotNull ParamMethodName o) {
    visitPsiElement(o);
  }

  public void visitModeExpression(@NotNull ParamModeExpression o) {
    visitPsiElement(o);
  }

  public void visitModeValue(@NotNull ParamModeValue o) {
    visitPsiElement(o);
  }

  public void visitParamList(@NotNull ParamParamList o) {
    visitPsiElement(o);
  }

  public void visitVar(@NotNull ParamVar o) {
    visitPsiElement(o);
  }

  public void visitVarExpression(@NotNull ParamVarExpression o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull ParamNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
