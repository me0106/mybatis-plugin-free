package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


import com.intellij.util.xml.*;
import com.intellij.util.xml.DomElement;
import me.nanlou.mybatis.dom.sub.curd.StatementType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * null:selectKeyElemType interface.
 * @author me
 */
public interface SelectKey extends DomElement {

	/**
	 * Returns the value of the simple content.
	 * @return the value of the simple content.
	 */
	@NotNull
	@Required
	String getValue();
	/**
	 * Sets the value of the simple content.
	 * @param value the new value to set
	 */
	void setValue(@NotNull String value);


	/**
	 * Returns the value of the resultType child.
	 * @return the value of the resultType child.
	 */
	@NotNull
	GenericAttributeValue<String> getResultType();


	/**
	 * Returns the value of the statementType child.
	 * @return the value of the statementType child.
	 */
	@NotNull
	GenericAttributeValue<StatementType> getStatementType();


	/**
	 * Returns the value of the keyProperty child.
	 * @return the value of the keyProperty child.
	 */
	@NotNull
	GenericAttributeValue<String> getKeyProperty();


	/**
	 * Returns the value of the keyColumn child.
	 * @return the value of the keyColumn child.
	 */
	@NotNull
	GenericAttributeValue<String> getKeyColumn();


	/**
	 * Returns the value of the order child.
	 * @return the value of the order child.
	 */
	@NotNull
	GenericAttributeValue<Order> getOrder();


	/**
	 * Returns the value of the databaseId child.
	 * @return the value of the databaseId child.
	 */
	@NotNull
	GenericAttributeValue<String> getDatabaseId();


	/**
	 * Returns the list of include children.
	 * @return the list of include children.
	 */
	@NotNull
	List<Include> getIncludes();
	/**
	 * Adds new child to the list of include children.
	 * @return created child
	 */
	Include addInclude();


	/**
	 * Returns the list of trim children.
	 * @return the list of trim children.
	 */
	@NotNull
	List<Trim> getTrims();
	/**
	 * Adds new child to the list of trim children.
	 * @return created child
	 */
	Trim addTrim();


	/**
	 * Returns the list of where children.
	 * @return the list of where children.
	 */
	@NotNull
	List<GenericDomValue<String>> getWheres();
	/**
	 * Adds new child to the list of where children.
	 * @return created child
	 */
	GenericDomValue<String> addWhere();


	/**
	 * Returns the list of set children.
	 * @return the list of set children.
	 */
	@NotNull
	List<GenericDomValue<String>> getSets();
	/**
	 * Adds new child to the list of set children.
	 * @return created child
	 */
	GenericDomValue<String> addSet();


	/**
	 * Returns the list of foreach children.
	 * @return the list of foreach children.
	 */
	@NotNull
	List<Foreach> getForeaches();
	/**
	 * Adds new child to the list of foreach children.
	 * @return created child
	 */
	Foreach addForeach();


	/**
	 * Returns the list of choose children.
	 * @return the list of choose children.
	 */
	@NotNull
	List<Choose> getChooses();
	/**
	 * Adds new child to the list of choose children.
	 * @return created child
	 */
	Choose addChoose();


	/**
	 * Returns the list of if children.
	 * @return the list of if children.
	 */
	@NotNull
	List<If> getIfs();
	/**
	 * Adds new child to the list of if children.
	 * @return created child
	 */
	If addIf();


	/**
	 * Returns the list of bind children.
	 * @return the list of bind children.
	 */
	@NotNull
	List<Bind> getBinds();
	/**
	 * Adds new child to the list of bind children.
	 * @return created child
	 */
	Bind addBind();


}
