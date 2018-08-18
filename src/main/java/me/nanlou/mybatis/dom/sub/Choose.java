package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:14 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:chooseElemType interface.
 * @author me
 */
public interface Choose extends DomElement {

	/**
	 * Returns the list of when children.
	 * @return the list of when children.
	 */
	@NotNull
	List<When> getWhens();
	/**
	 * Adds new child to the list of when children.
	 * @return created child
	 */
	When addWhen();


	/**
	 * Returns the value of the otherwise child.
	 * @return the value of the otherwise child.
	 */
	@NotNull
	GenericDomValue<String> getOtherwise();


}
