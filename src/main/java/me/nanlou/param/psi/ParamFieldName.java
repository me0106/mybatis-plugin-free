// This is a generated file. Not intended for manual editing.
package me.nanlou.param.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import me.nanlou.param.ParamNamedElement;

public interface ParamFieldName extends ParamNamedElement {

  String getKey();

  //WARNING: getValue(...) is skipped
  //matching getValue(ParamFieldName, ...)
  //methods are not found in ParamPsiImplUtil

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
