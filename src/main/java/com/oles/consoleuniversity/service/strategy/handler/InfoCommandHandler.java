package com.oles.consoleuniversity.service.strategy.handler;

import com.oles.consoleuniversity.service.strategy.CommandStrategy;
import com.oles.consoleuniversity.service.strategy.CommandType;
import org.springframework.stereotype.Component;
import static com.oles.consoleuniversity.utils.UtilsString.INFO;
import static com.oles.consoleuniversity.utils.UtilsString.INFO_LOGO;

@Component
public class InfoCommandHandler implements CommandStrategy {
    @Override
    public void handle(String userInput) {
        System.out.println(INFO_LOGO.concat(INFO));
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.INFO;
    }
}
