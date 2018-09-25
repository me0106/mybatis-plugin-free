package me.nanlou.mybatis.utils

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.psi.*
import com.intellij.psi.xml.XmlElement
import com.intellij.psi.xml.XmlFile
import com.intellij.psi.xml.XmlTag
import com.intellij.util.xml.DomManager
import com.intellij.util.xml.DomUtil
import me.nanlou.mybatis.dom.Mapper
import me.nanlou.mybatis.dom.sub.curd.CurdElement
import org.jetbrains.kotlin.psi.psiUtil.endOffset
import org.jetbrains.kotlin.psi.psiUtil.startOffset
import javax.swing.Icon

/**
 *
 * 扩展方法
 * @author me
 * Created by me on 2018-08-08 21:34
 */


/**
 * 查找当前XmlElement所隶属的curd标签的parameterType属性的对应psiClass
 *
 * eg: <mapper namespace="com.eg.Mapper">
 *          <select id="selectList" parameterType="com.eg.User">
 *              SELECT * FROM user WHERE name=1
 *          </select>
 *     </mapper>
 *  当xmlElement位于<select></select>内时
 * @see findCurdElementParameterTypeClass 该方法返回com.eg.User对应的psiClass
 *
 * @see findCurdElementIdMethod  该方法返回selectList对应的psiClass
 *
 * @see findXmlTag 该方法返回select方法对应的Select XmlTag
 * <link>http://www.jetbrains.org/intellij/sdk/docs/reference_guide/frameworks_and_external_apis/xml_dom_api.html</link>
 */

fun XmlElement.findCurdElementParameterTypeClass(): PsiClass? {
    //返回XmlTag对应的Statement对象(curd标签父对象)
    val stmt = DomUtil.findDomElement(this, CurdElement::class.java, false)
    return stmt?.parameterType?.value
}

/**
 * 查找当前xmlElement所隶属的curd标签所关联的psiMethod
 */
fun XmlElement.findCurdElementIdMethod(): PsiMethod? {
    //返回XmlTag对应的Statement对象(curd标签父对象)
    val stmt = DomUtil.findDomElement(this, CurdElement::class.java, false)
    return stmt?.id?.value
}


/**
 * 查找当前XmlElement对应的curd/ResultMap等二级XmlTag
 */
fun XmlElement.findXmlTag(): XmlTag? {
    val file = this.containingFile as XmlFile
    //获取当前Mapper文件的Dom树
    val e = DomManager.getDomManager(this.project).getFileElement(file, Mapper::class.java)
    //token相对于文本的偏移量
    val offset = this.textOffset
    //获取${}标签在哪个sql块里面(在哪个xmlTag里面)
    return e?.rootTag?.subTags?.find { it.startOffset < offset && it.endOffset > offset }
}

/**
 * 获取当前psiClass所有存在getter方法的属性
 */
fun PsiClass.pojoFields(): List<PsiField>? {
    return fields.filter {
        //获取属性的getter方法名
        val getter = it.getter()
        //查找是否存在getter方法
        return@filter this.findMethodsByName(getter, true).isNotEmpty()
    }.toList()
}


/**
 * 获取curd XmlTag的所有参数提示名与图标   (key-value键值对)==> (paramName-icon)
 */
fun XmlTag.findSqlParamNameMap(): Map<String, Icon> {
    val map = HashMap<String, Icon>()
    //获取所有存在getter方法的field，并加入map
    findCurdElementParameterTypeClass()?.pojoFields()?.forEach { map[it.name] = Icons.JAVA_FIELD_ICON }
    //获取当前sql关联的接口方法
    val method = findCurdElementIdMethod()
    val params = method?.parameterList?.parameters ?: return map
    for (i in params.indices) {
        map["param${i + 1}"] = Icons.JAVA_PARAMETER_ICON
        map[params[i].name!!] = Icons.JAVA_PARAMETER_ICON
    }
    return map
}

/**
 * 获取属性的getter方法名
 */

fun PsiField.getter(): String {
    return if (this.type == PsiType.BOOLEAN) {
        "is${this.name[0].toUpperCase()}${this.name.substring(1)}"
    } else {
        "get${this.name[0].toUpperCase()}${this.name.substring(1)}"
    }
}

fun <E> MutableCollection<E>.addWithReplace(e: E?): MutableCollection<E> {
    if (e == null) {
        return this
    }
    val ee = this.find { it.toString() == e.toString() }
    if (ee != null) {
        return this
    }
    this.add(e)
    return this
}

fun <T : PsiElement> RelatedItemLineMarkerInfo<T>.exist(element: PsiElement): Boolean {
    return this.element == element
}