package me.nanlou.param;

import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import me.nanlou.param.heightlight.ParamSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

/**
 * @author me
 * @date 2018-09-23 00:00
 */
public class ParamLanguage extends Language  implements InjectableLanguage {

    public static final ParamLanguage INSTANCE=new ParamLanguage();

    private static final String ID="Param";


    private ParamLanguage() {
        super(ID);
        SyntaxHighlighterFactory.LANGUAGE_FACTORY
                .addExplicitExtension(this, new SingleLazyInstanceSyntaxHighlighterFactory() {
                    @Override
                    @NotNull
                    protected SyntaxHighlighter createHighlighter() {
                        return new ParamSyntaxHighlighter();
                    }
                });
    }
}
