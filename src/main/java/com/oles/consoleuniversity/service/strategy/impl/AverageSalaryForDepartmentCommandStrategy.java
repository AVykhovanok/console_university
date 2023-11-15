package com.oles.consoleuniversity.service.strategy.impl;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.service.DepartmentService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AverageSalaryForDepartmentCommandStrategy implements CommandStrategy {
    private static final String AVERAGE_SALARY_ANSWER = "The average salary of %s is %,.2f";
    private final DepartmentService departmentService;

    @Autowired
    public AverageSalaryForDepartmentCommandStrategy(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void runStrategy(String userInput) {
        try {
            Double averageSalaryForDepartment = departmentService.getAverageSalaryForDepartment(userInput);
            System.out.printf((AVERAGE_SALARY_ANSWER) + "%n", userInput, averageSalaryForDepartment);
        }catch (NotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.AVERAGE_SALARY_FOR_DEPARTMENT;
    }
}
