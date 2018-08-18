package me.nanlou.mybatis.dom.sub.resultmap;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.psi.PsiClass;
import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import me.nanlou.mybatis.dom.sub.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:resultMapElemType interface.
 * @author me
 */
public interface ResultMap extends DomElement {

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
	GenericAttributeValue<PsiClass> getType();


	/**
	 * Returns the value of the extends child.
	 * @return the value of the extends child.
	 */
	@NotNull
	GenericAttributeValue<String> getExtends();


	/**
	 * Returns the value of the autoMapping child.
	 * @return the value of the autoMapping child.
	 */
	@NotNull
	GenericAttributeValue<AutoMapping> getAutoMapping();


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
