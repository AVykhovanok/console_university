package com.oles.consoleuniversity.utils;

import java.util.regex.Pattern;

public class UtilsRegex {
    public static final Pattern HEAD_OF_DEPARTMENT_RGX = Pattern.compile("((?i)who is head of department )((?i)[a-z]*)");
    public static final Pattern DEPARTMENT_STATISTICS_RGX = Pattern.compile("((?i)show )((?i)[a-z]*)((?i) statistics)");
    public static final Pattern AVERAGE_SALARY_FOR_DEPARTMENT_RGX = Pattern.compile("((?i)show the average salary for the department )((?i)[a-z]*)");
    public static final Pattern NUM_OF_EMPLOYEES_RGX = Pattern.compile("((?i)show count of employee for )((?i)[a-z]*)");
    public static final Pattern LECTOR_BY_TEMPLATE_RGX = Pattern.compile("((?i)global search by )((?i)[a-z]*)");
    public static final Pattern WRONG_COMMAND_RGX = Pattern.compile("()((?i)wrong)");
    public static final Pattern INFO_RGX = Pattern.compile("()((?i)info)");
    public static final Pattern EXIT_RGX = Pattern.compile("()((?i)exit)");
}
