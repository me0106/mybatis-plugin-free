package me.nanlou.param.heightlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import me.nanlou.param.lexer.ParamLexerAdapter
import me.nanlou.param.psi.ParamTypes

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

/**
 * @author me
 * @date 2018-09-23 17:47
 */
class ParamSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return ParamLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        if (tokenType == ParamTypes.IDENTIFIER) {
            return IDENTIFIER_KEY
        }
        if (tokenType == ParamTypes.JDBC_TYPE) {
            return JDBC_TYPE_KEY
        }
        if (tokenType == ParamTypes.JAVA_TYPE) {
            return JAVA_TYPE_KEY
        }
        if (tokenType == ParamTypes.MODE) {
            return MODE_KEY
        }
        if (tokenType == ParamTypes.AT) {
            return AT_KEY
        }
        if (tokenType == ParamTypes.COMMA) {
            return COMMA_KEY
        }
        if (tokenType == ParamTypes.LEFT_BRACKETS) {
            return LEFT_BRACKETS_KEY
        }
        if (tokenType == ParamTypes.RIGHT_BRACKETS) {
            return RIGHT_BRACKETS_KEY
        }
        if (tokenType == ParamTypes.PARAM_START) {
            return LEFT_BRACKETS_KEY
        }
        if (tokenType == ParamTypes.PARAM_END) {
            return RIGHT_BRACKETS_KEY
        }
        return if (tokenType == ParamTypes.EQ) {
            EQ_KEY
        } else BAD_CHARACTER_KEY
    }

    companion object {
        val JDBC_TYPE = createTextAttributesKey("PARAM.JDBC_TYPE", DefaultLanguageHighlighterColors.KEYWORD)
        val JAVA_TYPE = createTextAttributesKey("PARAM.JAVA_TYPE", DefaultLanguageHighlighterColors.KEYWORD)
        val MODE = createTextAttributesKey("PARAM.MODE", DefaultLanguageHighlighterColors.KEYWORD)
        val AT = createTextAttributesKey("PARAM.AT", DefaultLanguageHighlighterColors.KEYWORD)
        //
        val BAD_CHARACTER = createTextAttributesKey("PARAM.BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        val IDENTIFIER = createTextAttributesKey("PARAM.IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)

        val COMMA = createTextAttributesKey("PARAM.COMMA", DefaultLanguageHighlighterColors.COMMA)
        val LEFT_BRACKETS = createTextAttributesKey("PARAM.BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        val RIGHT_BRACKETS = createTextAttributesKey("PARAM.BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        val EQ = createTextAttributesKey("PARAM.EQ", DefaultLanguageHighlighterColors.OPERATION_SIGN)


        private val JDBC_TYPE_KEY = arrayOf(JDBC_TYPE)
        private val JAVA_TYPE_KEY = arrayOf(JAVA_TYPE)
        private val MODE_KEY = arrayOf(MODE)
        private val AT_KEY = arrayOf(AT)
        //
        private val BAD_CHARACTER_KEY = arrayOf(BAD_CHARACTER)
        private val IDENTIFIER_KEY = arrayOf(IDENTIFIER)

        private val COMMA_KEY = arrayOf(COMMA)
        private val LEFT_BRACKETS_KEY = arrayOf(LEFT_BRACKETS)
        private val RIGHT_BRACKETS_KEY = arrayOf(RIGHT_BRACKETS)
        private val EQ_KEY = arrayOf(EQ)
    }
}
