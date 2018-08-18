package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

/**
 * null:typeAliasElemType interface.
 * @author me
 */
public interface TypeAlias extends DomElement {

	/**
	 * Returns the value of the alias child.
	 * @return the value of the alias child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getAlias();


	/**
	 * Returns the value of the type child.
	 * @return the value of the type child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getType();


}
