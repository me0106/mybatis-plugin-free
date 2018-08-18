package me.nanlou.mybatis.dom.sub;// Generated on Sun Aug 12 04:02:15 CST 2018
// DTD/Schema  :    null


/**
 * null:fetchTypeAttrType enumeration.
 * @author me
 */
public enum FetchType implements com.intellij.util.xml.NamedEnum {
	EAGER ("eager"),
	LAZY ("lazy");

	private final String value;
	private FetchType(String value) { this.value = value; }
	public String getValue() { return value; }

}
