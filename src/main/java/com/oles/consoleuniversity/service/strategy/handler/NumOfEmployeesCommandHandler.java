package com.oles.consoleuniversity.service.strategy.handler;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.service.DepartmentService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumOfEmployeesCommandHandler implements CommandStrategy {
    private final DepartmentService departmentService;

    @Override
    public void handle(String userInput) {
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
