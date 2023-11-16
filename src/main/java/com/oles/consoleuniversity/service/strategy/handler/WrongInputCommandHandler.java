package com.oles.consoleuniversity.service.strategy.handler;

import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import org.springframework.stereotype.Component;
import static com.oles.consoleuniversity.utils.UtilsString.WRONG_COMMAND;

@Component
public class WrongInputCommandHandler implements CommandStrategy {
    @Override
    public void handle(String userInput) {
        System.out.println(WRONG_COMMAND);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRONG_COMMAND;
    }
}
