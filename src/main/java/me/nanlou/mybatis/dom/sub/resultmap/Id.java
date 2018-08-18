package me.nanlou.mybatis.dom.sub.resultmap;


import com.intellij.psi.PsiField;
import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

/**
 * null:idElemType interface.
 * @author me
 */
public interface Id extends DomElement {

	/**
	 * Returns the value of the property child.
	 * @return the value of the property child.
	 */
	@NotNull
	GenericAttributeValue<PsiField> getProperty();


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


}
