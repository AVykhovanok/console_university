package com.oles.consoleuniversity.service.strategy.impl;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.model.Lector;
import com.oles.consoleuniversity.service.DepartmentService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadOfDepartmentCommandStrategyImpl implements CommandStrategy {
    private static final String EMPTY_HEAD_OF_DEPARTMENT = "There is not head of department";
    private static final String HEAD_OF_DEPARTMENT_ANSWER = "Head of %s department is %s";
    private final DepartmentService departmentService;

    @Autowired
    public HeadOfDepartmentCommandStrategyImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void runStrategy(String userInput) {
        try {
            Lector headOfDepartment = departmentService.getHeadOfDepartment(userInput);
            System.out.printf((HEAD_OF_DEPARTMENT_ANSWER) + "%n", userInput, headOfDepartment);
        }catch(NotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.HEAD_OF_DEPARTMENT;
    }
}
