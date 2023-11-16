package com.oles.consoleuniversity.service.strategy;

public interface CommandStrategy {
    void handle(String userInput);
    CommandType getCommandType();
}
