package me.nanlou.param.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static me.nanlou.param.psi.ParamTypes.*;

%%

%{
  public _ParamLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _ParamLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "."                { return DOT; }
  "@"                { return AT; }
  ","                { return COMMA; }
  "("                { return LEFT_BRACKETS; }
  ")"                { return RIGHT_BRACKETS; }
  "="                { return EQ; }
  "javaType"         { return JAVA_TYPE; }
  "jdbcType"         { return JDBC_TYPE; }
  "mode"             { return MODE; }
  "#{"               { return PARAM_START; }
  "}"                { return PARAM_END; }

  {IDENTIFIER}       { return IDENTIFIER; }

}

[^] { return BAD_CHARACTER; }
