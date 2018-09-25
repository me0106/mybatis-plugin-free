package me.nanlou.param.lexer;

import com.intellij.lexer.FlexAdapter;

/**
 * @author me
 * @date 2018-09-23 12:00
 */
public class ParamLexerAdapter extends FlexAdapter {
    public ParamLexerAdapter() {
        super(new _ParamLexer());
    }
}
