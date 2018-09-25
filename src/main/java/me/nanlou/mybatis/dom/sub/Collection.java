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
 * null:collectionElemType interface.
 * @author me
 */
public interface Collection extends DomElement {

	/**
	 * Returns the value of the property child.
	 * @return the value of the property child.
	 */
	@NotNull
	@Required
	GenericAttributeValue<String> getProperty();


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
	GenericAttributeValue<String> getJavaType();


	/**
	 * Returns the value of the ofType child.
	 * @return the value of the ofType child.
	 */
	@NotNull
	GenericAttributeValue<String> getOfType();


	/**
	 * Returns the value of the jdbcType child.
	 * @return the value of the jdbcType child.
	 */
	@NotNull
	GenericAttributeValue<String> getJdbcType();


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
	 * Returns the value of the typeHandler child.
	 * @return the value of the typeHandler child.
	 */
	@NotNull
	GenericAttributeValue<String> getTypeHandler();


	/**
	 * Returns the value of the notNullColumn child.
	 * @return the value of the notNullColumn child.
	 */
	@NotNull
	GenericAttributeValue<String> getNotNullColumn();


	/**
	 * Returns the value of the columnPrefix child.
	 * @return the value of the columnPrefix child.
	 */
	@NotNull
	GenericAttributeValue<String> getColumnPrefix();


	/**
	 * Returns the value of the resultSet child.
	 * @return the value of the resultSet child.
	 */
	@NotNull
	GenericAttributeValue<String> getResultSet();


	/**
	 * Returns the value of the foreignColumn child.
	 * @return the value of the foreignColumn child.
	 */
	@NotNull
	GenericAttributeValue<String> getForeignColumn();


	/**
	 * Returns the value of the autoMapping child.
	 * @return the value of the autoMapping child.
	 */
	@NotNull
	GenericAttributeValue<AutoMapping> getAutoMapping();


	/**
	 * Returns the value of the fetchType child.
	 * @return the value of the fetchType child.
	 */
	@NotNull
	GenericAttributeValue<FetchType> getFetchType();


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
