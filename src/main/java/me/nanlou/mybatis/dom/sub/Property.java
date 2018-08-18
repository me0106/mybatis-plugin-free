package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

/**
 * null:propertyElemType interface.
 * @author me
 */
public interface Property extends DomElement {

	/**
	 * Returns the value of the name child.
	 * @return the value of the name child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getName();


	/**
	 * Returns the value of the value child.
	 * @return the value of the value child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getValue();


}
