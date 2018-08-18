package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:14 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

/**
 * null:argElemType interface.
 * @author me
 */
public interface Arg extends DomElement {

	/**
	 * Returns the value of the javaType child.
	 * @return the value of the javaType child.
	 */
	@NotNull
	GenericAttributeValue<String> getJavaType();


	/**
	 * Returns the value of the column child.
	 * @return the value of the column child.
	 */
	@NotNull
	GenericAttributeValue<String> getColumn();


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
	 * Returns the value of the select child.
	 * @return the value of the select child.
	 */
	@NotNull
	GenericAttributeValue<String> getSelect();


	/**
	 * Returns the value of the resultMap child.
	 * @return the value of the resultMap child.
	 */
	@NotNull
	GenericAttributeValue<String> getResultMap();


	/**
	 * Returns the value of the name child.
	 * @return the value of the name child.
	 */
	@NotNull
	GenericAttributeValue<String> getName();


}
