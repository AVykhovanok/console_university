package com.oles.consoleuniversity.service.strategy.impl;

import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import org.springframework.stereotype.Component;

import static com.oles.consoleuniversity.utils.UtilsString.EXITING;

@Component
public class ExitCommandStrategy implements CommandStrategy {
    @Override
    public void runStrategy(String userInput) {
        System.out.println(EXITING);
        System.exit(0);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.EXIT;
    }
}
