// This is a generated file. Not intended for manual editing.
package me.nanlou.param.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static me.nanlou.param.psi.ParamTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ParamParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == CLASS_NAME) {
      r = className(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0);
    }
    else if (t == FIELD) {
      r = field(b, 0);
    }
    else if (t == JAVA_TYPE_EXPRESSION) {
      r = javaTypeExpression(b, 0);
    }
    else if (t == JAVA_TYPE_VALUE) {
      r = javaTypeValue(b, 0);
    }
    else if (t == JDBC_TYPE_EXPRESSION) {
      r = jdbcTypeExpression(b, 0);
    }
    else if (t == JDBC_TYPE_VALUE) {
      r = jdbcTypeValue(b, 0);
    }
    else if (t == METHOD) {
      r = method(b, 0);
    }
    else if (t == METHOD_NAME) {
      r = methodName(b, 0);
    }
    else if (t == MODE_EXPRESSION) {
      r = modeExpression(b, 0);
    }
    else if (t == MODE_VALUE) {
      r = modeValue(b, 0);
    }
    else if (t == PARAM_LIST) {
      r = paramList(b, 0);
    }
    else if (t == VAR) {
      r = var(b, 0);
    }
    else if (t == VAR_EXPRESSION) {
      r = varExpression(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return paramFile(b, l + 1);
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)*
  public static boolean className(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "className")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && className_1(b, l + 1);
    exit_section_(b, m, CLASS_NAME, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean className_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "className_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!className_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "className_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean className_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "className_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // varExpression {COMMA (jdbcTypeExpression|javaTypeExpression|modeExpression)}*
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    if (!nextTokenIs(b, "<expression>", AT, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = varExpression(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {COMMA (jdbcTypeExpression|javaTypeExpression|modeExpression)}*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // COMMA (jdbcTypeExpression|javaTypeExpression|modeExpression)
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // jdbcTypeExpression|javaTypeExpression|modeExpression
  private static boolean expression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0_1")) return false;
    boolean r;
    r = jdbcTypeExpression(b, l + 1);
    if (!r) r = javaTypeExpression(b, l + 1);
    if (!r) r = modeExpression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)*
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && field_1(b, l + 1);
    exit_section_(b, m, FIELD, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // JAVA_TYPE EQ [javaTypeValue]
  public static boolean javaTypeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javaTypeExpression")) return false;
    if (!nextTokenIs(b, JAVA_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, JAVA_TYPE, EQ);
    r = r && javaTypeExpression_2(b, l + 1);
    exit_section_(b, m, JAVA_TYPE_EXPRESSION, r);
    return r;
  }

  // [javaTypeValue]
  private static boolean javaTypeExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javaTypeExpression_2")) return false;
    javaTypeValue(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)*
  public static boolean javaTypeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javaTypeValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && javaTypeValue_1(b, l + 1);
    exit_section_(b, m, JAVA_TYPE_VALUE, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean javaTypeValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javaTypeValue_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!javaTypeValue_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "javaTypeValue_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean javaTypeValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "javaTypeValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // JDBC_TYPE EQ [jdbcTypeValue]
  public static boolean jdbcTypeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jdbcTypeExpression")) return false;
    if (!nextTokenIs(b, JDBC_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, JDBC_TYPE, EQ);
    r = r && jdbcTypeExpression_2(b, l + 1);
    exit_section_(b, m, JDBC_TYPE_EXPRESSION, r);
    return r;
  }

  // [jdbcTypeValue]
  private static boolean jdbcTypeExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jdbcTypeExpression_2")) return false;
    jdbcTypeValue(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)*
  public static boolean jdbcTypeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jdbcTypeValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && jdbcTypeValue_1(b, l + 1);
    exit_section_(b, m, JDBC_TYPE_VALUE, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean jdbcTypeValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jdbcTypeValue_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!jdbcTypeValue_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jdbcTypeValue_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean jdbcTypeValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jdbcTypeValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AT className AT methodName LEFT_BRACKETS [paramList] RIGHT_BRACKETS
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && className(b, l + 1);
    r = r && consumeToken(b, AT);
    r = r && methodName(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACKETS);
    r = r && method_5(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKETS);
    exit_section_(b, m, METHOD, r);
    return r;
  }

  // [paramList]
  private static boolean method_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_5")) return false;
    paramList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)*
  public static boolean methodName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && methodName_1(b, l + 1);
    exit_section_(b, m, METHOD_NAME, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean methodName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!methodName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "methodName_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean methodName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MODE EQ [modeValue]
  public static boolean modeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modeExpression")) return false;
    if (!nextTokenIs(b, MODE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MODE, EQ);
    r = r && modeExpression_2(b, l + 1);
    exit_section_(b, m, MODE_EXPRESSION, r);
    return r;
  }

  // [modeValue]
  private static boolean modeExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modeExpression_2")) return false;
    modeValue(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)*
  public static boolean modeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modeValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && modeValue_1(b, l + 1);
    exit_section_(b, m, MODE_VALUE, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean modeValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modeValue_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!modeValue_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modeValue_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean modeValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modeValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PARAM_START expression PARAM_END
  static boolean paramFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramFile")) return false;
    if (!nextTokenIs(b, PARAM_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_START);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PARAM_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var(COMMA var)*
  public static boolean paramList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var(b, l + 1);
    r = r && paramList_1(b, l + 1);
    exit_section_(b, m, PARAM_LIST, r);
    return r;
  }

  // (COMMA var)*
  private static boolean paramList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!paramList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paramList_1", c)) break;
    }
    return true;
  }

  // COMMA var
  private static boolean paramList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && var(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER(DOT IDENTIFIER)*
  public static boolean var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && var_1(b, l + 1);
    exit_section_(b, m, VAR, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean var_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!var_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "var_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean var_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // field|method
  public static boolean varExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varExpression")) return false;
    if (!nextTokenIs(b, "<var expression>", AT, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_EXPRESSION, "<var expression>");
    r = field(b, l + 1);
    if (!r) r = method(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
