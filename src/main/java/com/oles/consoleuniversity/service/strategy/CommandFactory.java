package com.oles.consoleuniversity.service.strategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandFactory {
    private Map<CommandType, CommandStrategy> commandStrategyMap;

    @Autowired
    public CommandFactory(Set<CommandStrategy> commandStrategySet) {
        createStrategy(commandStrategySet);
    }

    public CommandStrategy findStrategy(CommandType commandType) {
        return commandStrategyMap.get(commandType);
    }
    private void createStrategy(Set<CommandStrategy> commandStrategySet) {
        commandStrategyMap = new LinkedHashMap<>();
        commandStrategySet.forEach(
            strategy -> commandStrategyMap.put(strategy.getCommandType(), strategy));
    }
}
