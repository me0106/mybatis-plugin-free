package me.nanlou.mybatis.inspection.check.xml;

import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.ProblemDescriptor;
import me.nanlou.mybatis.dom.Mapper;

import java.util.List;

/**
 * @author me
 * @date 2018-09-26 14:30
 */
public interface XmlChecker {
    List<ProblemDescriptor> check(Mapper mapper, InspectionManager manager);
}
