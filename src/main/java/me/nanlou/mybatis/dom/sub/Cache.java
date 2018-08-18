package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:14 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:cacheElemType interface.
 * @author me
 */
public interface Cache extends DomElement {

	/**
	 * Returns the value of the type child.
	 * @return the value of the type child.
	 */
	@NotNull
	GenericAttributeValue<String> getType();


	/**
	 * Returns the value of the eviction child.
	 * @return the value of the eviction child.
	 */
	@NotNull
	GenericAttributeValue<String> getEviction();


	/**
	 * Returns the value of the flushInterval child.
	 * @return the value of the flushInterval child.
	 */
	@NotNull
	GenericAttributeValue<String> getFlushInterval();


	/**
	 * Returns the value of the size child.
	 * @return the value of the size child.
	 */
	@NotNull
	GenericAttributeValue<String> getSize();


	/**
	 * Returns the value of the readOnly child.
	 * @return the value of the readOnly child.
	 */
	@NotNull
	GenericAttributeValue<String> getReadOnly();


	/**
	 * Returns the value of the blocking child.
	 * @return the value of the blocking child.
	 */
	@NotNull
	GenericAttributeValue<String> getBlocking();


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
