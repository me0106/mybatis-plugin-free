package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:constructorElemType interface.
 * @author me
 */
public interface Constructor extends DomElement {

	/**
	 * Returns the list of idArg children.
	 * @return the list of idArg children.
	 */
	@NotNull
	@SubTagList ("idArg")
	List<IdArg> getIdArgs();
	/**
	 * Adds new child to the list of idArg children.
	 * @return created child
	 */
	@SubTagList ("idArg")
	IdArg addIdArg();


	/**
	 * Returns the list of arg children.
	 * @return the list of arg children.
	 */
	@NotNull
	List<Arg> getArgs();
	/**
	 * Adds new child to the list of arg children.
	 * @return created child
	 */
	Arg addArg();


}
