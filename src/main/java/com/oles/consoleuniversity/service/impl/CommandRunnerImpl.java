package com.oles.consoleuniversity.service.impl;

import com.oles.consoleuniversity.service.CommandRunnerService;
import com.oles.consoleuniversity.service.strategy.CommandFactory;
import com.oles.consoleuniversity.service.strategy.CommandType;
import java.util.regex.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandRunnerImpl implements CommandRunnerService {
    private final CommandFactory commandFactory;

    @Autowired
    public CommandRunnerImpl(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void runCommand(String input) {
        CommandType command = CommandType.getCommandType(input);
        Matcher m = command.getCommandRgx().matcher(input);
        String userInputValue = "";
        while (m.find()) {
            userInputValue = m.group(2);
        }
        commandFactory.findStrategy(command).runStrategy(userInputValue);
    }
}
