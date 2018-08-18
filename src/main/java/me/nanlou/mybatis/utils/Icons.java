/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package me.nanlou.mybatis.utils;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * all icons used in this plugin
 * <p>
 * Author: jianyu.lin
 * Date: 2016/11/25 Time: 下午7:29
 */
public interface Icons {

    Icon JAVA_TO_XML_ICON = IconLoader.getIcon("/icons/mybatis/navigateDown.png");
    Icon XML_TO_JAVA_ICON = IconLoader.getIcon("/icons/mybatis/navigateUp.png");
    Icon JAVA_PARAMETER_ICON = IconLoader.getIcon("/nodes/parameter.svg");
    Icon JAVA_METHOD_ICON = IconLoader.getIcon("/nodes/method.svg");
    Icon XML_TAG_ICON = IconLoader.getIcon("/nodes/tag.png");
    Icon ERROR_ICON = IconLoader.getIcon("/general/error.svg");
    Icon JAVA_FIELD_ICON = IconLoader.getIcon("/nodes/field.svg");
    Icon MAPPER_ICON = IconLoader.getIcon("/icons/mybatis/mapper.png");
}