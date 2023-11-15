package com.oles.consoleuniversity.service.strategy;

public interface CommandStrategy {
    void runStrategy(String userInput);
    CommandType getCommandType();
}
