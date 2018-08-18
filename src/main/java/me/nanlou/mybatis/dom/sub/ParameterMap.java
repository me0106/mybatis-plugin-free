package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:parameterMapElemType interface.
 * @author me
 */
public interface ParameterMap extends DomElement {

	/**
	 * Returns the value of the id child.
	 * @return the value of the id child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getId();


	/**
	 * Returns the value of the type child.
	 * @return the value of the type child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getType();


	/**
	 * Returns the list of parameter children.
	 * @return the list of parameter children.
	 */
	@NotNull
	List<Parameter> getParameters();
	/**
	 * Adds new child to the list of parameter children.
	 * @return created child
	 */
	Parameter addParameter();


}
