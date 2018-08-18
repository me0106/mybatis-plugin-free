package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

/**
 * null:parameterElemType interface.
 * @author me
 */
public interface Parameter extends DomElement {

	/**
	 * Returns the value of the property child.
	 * @return the value of the property child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getProperty();


	/**
	 * Returns the value of the javaType child.
	 * @return the value of the javaType child.
	 */
	@NotNull
	GenericAttributeValue<String> getJavaType();


	/**
	 * Returns the value of the jdbcType child.
	 * @return the value of the jdbcType child.
	 */
	@NotNull
	GenericAttributeValue<String> getJdbcType();


	/**
	 * Returns the value of the mode child.
	 * @return the value of the mode child.
	 */
	@NotNull
	GenericAttributeValue<Mode> getMode();


	/**
	 * Returns the value of the resultMap child.
	 * @return the value of the resultMap child.
	 */
	@NotNull
	GenericAttributeValue<String> getResultMap();


	/**
	 * Returns the value of the scale child.
	 * @return the value of the scale child.
	 */
	@NotNull
	GenericAttributeValue<String> getScale();


	/**
	 * Returns the value of the typeHandler child.
	 * @return the value of the typeHandler child.
	 */
	@NotNull
	GenericAttributeValue<String> getTypeHandler();


}
