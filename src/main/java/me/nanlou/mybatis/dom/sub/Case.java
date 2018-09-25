package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:14 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import me.nanlou.mybatis.dom.sub.resultmap.Constructor;
import me.nanlou.mybatis.dom.sub.resultmap.Id;
import me.nanlou.mybatis.dom.sub.resultmap.Result;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:caseElemType interface.
 * @author me
 */
public interface Case extends DomElement {

	/**
	 * Returns the value of the value child.
	 * @return the value of the value child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getValue();


	/**
	 * Returns the value of the resultMap child.
	 * @return the value of the resultMap child.
	 */
	@NotNull
	GenericAttributeValue<String> getResultMap();


	/**
	 * Returns the value of the resultType child.
	 * @return the value of the resultType child.
	 */
	@NotNull
	GenericAttributeValue<String> getResultType();


	/**
	 * Returns the value of the constructor child.
	 * @return the value of the constructor child.
	 */
	@NotNull
    Constructor getConstructor();


	/**
	 * Returns the list of id children.
	 * @return the list of id children.
	 */
	@NotNull
	List<Id> getIds();
	/**
	 * Adds new child to the list of id children.
	 * @return created child
	 */
	Id addId();


	/**
	 * Returns the list of result children.
	 * @return the list of result children.
	 */
	@NotNull
	List<Result> getResults();
	/**
	 * Adds new child to the list of result children.
	 * @return created child
	 */
	Result addResult();


	/**
	 * Returns the list of association children.
	 * @return the list of association children.
	 */
	@NotNull
	List<Association> getAssociations();
	/**
	 * Adds new child to the list of association children.
	 * @return created child
	 */
	Association addAssociation();


	/**
	 * Returns the list of collection children.
	 * @return the list of collection children.
	 */
	@NotNull
	List<Collection> getCollections();
	/**
	 * Adds new child to the list of collection children.
	 * @return created child
	 */
	Collection addCollection();


	/**
	 * Returns the value of the discriminator child.
	 * @return the value of the discriminator child.
	 */
	@NotNull
	Discriminator getDiscriminator();


}
