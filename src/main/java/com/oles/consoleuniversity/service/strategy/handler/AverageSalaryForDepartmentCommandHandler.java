package com.oles.consoleuniversity.service.strategy.handler;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.service.DepartmentService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AverageSalaryForDepartmentCommandHandler implements CommandStrategy {
    private static final String AVERAGE_SALARY_ANSWER = "The average salary of %s is %,.2f";
    private final DepartmentService departmentService;


    @Override
    public void handle(String userInput) {
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
