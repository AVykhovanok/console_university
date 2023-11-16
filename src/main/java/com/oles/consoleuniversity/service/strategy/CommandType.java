package com.oles.consoleuniversity.service.strategy;

import java.util.Arrays;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import static com.oles.consoleuniversity.utils.UtilsRegex.*;

@RequiredArgsConstructor
public enum CommandType {
    HEAD_OF_DEPARTMENT(HEAD_OF_DEPARTMENT_RGX),
    DEPARTMENT_STATISTICS(DEPARTMENT_STATISTICS_RGX),
    AVERAGE_SALARY_FOR_DEPARTMENT(AVERAGE_SALARY_FOR_DEPARTMENT_RGX),
    NUM_OF_EMPLOYEES(NUM_OF_EMPLOYEES_RGX),
    LECTOR_BY_TEMPLATE(LECTOR_BY_TEMPLATE_RGX),
    WRONG_COMMAND(WRONG_COMMAND_RGX),
    INFO(INFO_RGX),
    EXIT(EXIT_RGX);

    private final Pattern patternType;

    public Pattern getCommandRgx(){
        return patternType;
    }

    public static CommandType getCommandType(String inputString){
        return Arrays.stream(CommandType.values())
            .filter(commandType -> commandType.patternType.matcher(inputString).matches())
            .findAny()
            .orElse(WRONG_COMMAND);

    }
}
