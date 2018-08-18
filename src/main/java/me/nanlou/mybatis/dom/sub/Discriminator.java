package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:discriminatorElemType interface.
 * @author me
 */
public interface Discriminator extends DomElement {

	/**
	 * Returns the value of the column child.
	 * @return the value of the column child.
	 */
	@NotNull
	GenericAttributeValue<String> getColumn();


	/**
	 * Returns the value of the javaType child.
	 * @return the value of the javaType child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getJavaType();


	/**
	 * Returns the value of the jdbcType child.
	 * @return the value of the jdbcType child.
	 */
	@NotNull
	GenericAttributeValue<String> getJdbcType();


	/**
	 * Returns the value of the typeHandler child.
	 * @return the value of the typeHandler child.
	 */
	@NotNull
	GenericAttributeValue<String> getTypeHandler();


	/**
	 * Returns the list of case children.
	 * @return the list of case children.
	 */
	@NotNull
	@Required
	List<Case> getCases();
	/**
	 * Adds new child to the list of case children.
	 * @return created child
	 */
	Case addCase();


}
