package com.oles.consoleuniversity.service.strategy.handler;

import com.oles.consoleuniversity.exception.NotExistException;
import com.oles.consoleuniversity.service.LectorService;
import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LectorByTemplateCommandHandler implements CommandStrategy {
    private final LectorService lectorService;

    @Override
    public void handle(String userInput) {
        try {
            System.out.println(lectorService.getLectorByTemplate(userInput).toString().replaceAll("(^\\[|\\]$)", ""));
        }catch(NotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.LECTOR_BY_TEMPLATE;
    }
}
