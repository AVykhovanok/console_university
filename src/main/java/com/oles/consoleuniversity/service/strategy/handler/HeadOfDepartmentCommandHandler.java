package com.oles.consoleuniversity.service.strategy.handler;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.model.Lector;
import com.oles.consoleuniversity.service.DepartmentService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeadOfDepartmentCommandHandler implements CommandStrategy {
    private static final String HEAD_OF_DEPARTMENT_ANSWER = "Head of %s department is %s";
    private final DepartmentService departmentService;

    @Override
    public void handle(String userInput) {
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
