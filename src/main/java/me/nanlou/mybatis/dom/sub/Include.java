package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:includeElemType interface.
 * @author me
 */
public interface Include extends DomElement {

	/**
	 * Returns the value of the refid child.
	 * @return the value of the refid child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getRefid();


	/**
	 * Returns the list of property children.
	 * @return the list of property children.
	 */
	@NotNull
	List<Property> getProperties();
	/**
	 * Adds new child to the list of property children.
	 * @return created child
	 */
	Property addProperty();


}
