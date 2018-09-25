// This is a generated file. Not intended for manual editing.
package me.nanlou.param.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import me.nanlou.param.ParamElementType;
import me.nanlou.param.ParamTokenType;
import me.nanlou.param.psi.impl.*;

public interface ParamTypes {

  IElementType CLASS_NAME = new ParamElementType("CLASS_NAME");
  IElementType EXPRESSION = new ParamElementType("EXPRESSION");
  IElementType FIELD_NAME = new ParamElementType("FIELD_NAME");
  IElementType JAVA_TYPE_EXPRESSION = new ParamElementType("JAVA_TYPE_EXPRESSION");
  IElementType JAVA_TYPE_VALUE = new ParamElementType("JAVA_TYPE_VALUE");
  IElementType JDBC_TYPE_EXPRESSION = new ParamElementType("JDBC_TYPE_EXPRESSION");
  IElementType JDBC_TYPE_VALUE = new ParamElementType("JDBC_TYPE_VALUE");
  IElementType METHOD_CALL = new ParamElementType("METHOD_CALL");
  IElementType METHOD_NAME = new ParamElementType("METHOD_NAME");
  IElementType MODE_EXPRESSION = new ParamElementType("MODE_EXPRESSION");
  IElementType MODE_VALUE = new ParamElementType("MODE_VALUE");
  IElementType PARAM_LIST = new ParamElementType("PARAM_LIST");
  IElementType VAR = new ParamElementType("VAR");
  IElementType VAR_EXPRESSION = new ParamElementType("VAR_EXPRESSION");

  IElementType AT = new ParamTokenType("@");
  IElementType COMMA = new ParamTokenType(",");
  IElementType DOT = new ParamTokenType(".");
  IElementType EQ = new ParamTokenType("=");
  IElementType IDENTIFIER = new ParamTokenType("IDENTIFIER");
  IElementType JAVA_TYPE = new ParamTokenType("javaType");
  IElementType JDBC_TYPE = new ParamTokenType("jdbcType");
  IElementType LEFT_BRACKETS = new ParamTokenType("(");
  IElementType MODE = new ParamTokenType("mode");
  IElementType PARAM_END = new ParamTokenType("}");
  IElementType PARAM_START = new ParamTokenType("#{");
  IElementType RIGHT_BRACKETS = new ParamTokenType(")");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == CLASS_NAME) {
        return new ParamClassNameImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ParamExpressionImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new ParamFieldNameImpl(node);
      }
      else if (type == JAVA_TYPE_EXPRESSION) {
        return new ParamJavaTypeExpressionImpl(node);
      }
      else if (type == JAVA_TYPE_VALUE) {
        return new ParamJavaTypeValueImpl(node);
      }
      else if (type == JDBC_TYPE_EXPRESSION) {
        return new ParamJdbcTypeExpressionImpl(node);
      }
      else if (type == JDBC_TYPE_VALUE) {
        return new ParamJdbcTypeValueImpl(node);
      }
      else if (type == METHOD_CALL) {
        return new ParamMethodCallImpl(node);
      }
      else if (type == METHOD_NAME) {
        return new ParamMethodNameImpl(node);
      }
      else if (type == MODE_EXPRESSION) {
        return new ParamModeExpressionImpl(node);
      }
      else if (type == MODE_VALUE) {
        return new ParamModeValueImpl(node);
      }
      else if (type == PARAM_LIST) {
        return new ParamParamListImpl(node);
      }
      else if (type == VAR) {
        return new ParamVarImpl(node);
      }
      else if (type == VAR_EXPRESSION) {
        return new ParamVarExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
