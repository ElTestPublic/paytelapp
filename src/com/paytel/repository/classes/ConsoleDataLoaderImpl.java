package com.paytel.repository.classes;


import com.paytel.model.MessageLevel;
import com.paytel.repository.DataLoader;
import com.paytel.services.classes.ConsoleLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleDataLoaderImpl implements DataLoader<String> {
    private ConsoleLog consoleLog;

    public ConsoleDataLoaderImpl(ConsoleLog consoleLog) {
        this.consoleLog = consoleLog;
    }

    @Override
    public String getData(String dataName) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            consoleLog.printAppMsg("Error while getting console input" + e, MessageLevel.ERROR);
            return null;
        }
    }
}
