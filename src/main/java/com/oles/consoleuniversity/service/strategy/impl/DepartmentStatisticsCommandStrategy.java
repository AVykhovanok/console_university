package com.oles.consoleuniversity.service.strategy.impl;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.service.DepartmentService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentStatisticsCommandStrategy implements CommandStrategy {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentStatisticsCommandStrategy(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void runStrategy(String userInput) {
        try {
            String departmentStatistics = departmentService.getDepartmentStatistics(userInput);
            System.out.println(departmentStatistics);
        }catch (NotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DEPARTMENT_STATISTICS;
    }
}
