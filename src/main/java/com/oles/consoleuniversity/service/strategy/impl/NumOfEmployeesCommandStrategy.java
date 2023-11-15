package com.oles.consoleuniversity.service.strategy.impl;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.service.DepartmentService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumOfEmployeesCommandStrategy implements CommandStrategy {
    private final DepartmentService departmentService;

    @Autowired
    public NumOfEmployeesCommandStrategy(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void runStrategy(String userInput) {
        try {
            System.out.println(departmentService.getNumOfEmployees(userInput));
        } catch (NotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.NUM_OF_EMPLOYEES;
    }
}
