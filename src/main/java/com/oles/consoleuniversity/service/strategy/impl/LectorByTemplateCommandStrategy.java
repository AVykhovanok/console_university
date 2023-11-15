package com.oles.consoleuniversity.service.strategy.impl;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.service.LectorService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LectorByTemplateCommandStrategy implements CommandStrategy {
    private final LectorService lectorService;

    @Autowired
    public LectorByTemplateCommandStrategy(LectorService lectorService) {
        this.lectorService = lectorService;
    }

    @Override
    public void runStrategy(String userInput) {
        try {
            System.out.println(lectorService.getLectorByTemplate(userInput).toString().trim());
        }catch(NotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.LECTOR_BY_TEMPLATE;
    }
}
