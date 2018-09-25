package me.nanlou.param;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import me.nanlou.param.psi.ParamField;
import me.nanlou.param.psi.ParamTypes;

/**
 * @author me
 * @date 2018-09-24 22:57
 */
public class ParamPsiImplUtil {
//getKey getValue getName setName getNameIdentifier

    public static String getName(ParamField element) {
        return getKey(element);
    }

    public static String getKey(ParamField element) {
        ASTNode nameNode = element.getNode().findChildByType(ParamTypes.FIELD);
        if (nameNode != null) {
            return nameNode.getText();
        } else {
            return null;
        }
    }

    public static PsiElement setName(ParamField element, String newName) {
        ASTNode nameNode = element.getNode().findChildByType(ParamTypes.FIELD);
        if (nameNode != null) {
            ParamField name = ParamElementFactory.createProperty(element.getProject(), newName);
            ASTNode newNameNode = name.getFirstChild().getNode();
            element.getNode().replaceChild(nameNode, newNameNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(ParamField element) {
        ASTNode nameNode = element.getNode().findChildByType(ParamTypes.FIELD);
        if (nameNode != null) {
            return nameNode.getPsi();
        } else {
            return null;
        }
    }
}
