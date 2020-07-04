package com.paytel.controlers;

import com.paytel.model.MessageLevel;
import com.paytel.repository.classes.ConsoleDataLoaderImpl;
import com.paytel.repository.classes.FileDataLoaderImpl;
import com.paytel.services.classes.AppCountService;
import com.paytel.services.classes.ConsoleLog;
import com.paytel.services.classes.TxtFileParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppControler {

    public void countAvergeNumber() {
        ConsoleLog consoleLog = new ConsoleLog();
        ConsoleDataLoaderImpl consoleDataLoaderDaoImpl = new ConsoleDataLoaderImpl(consoleLog);
        FileDataLoaderImpl fileDataLoaderDaoImpl = new FileDataLoaderImpl();
        TxtFileParser txtFileParser = new TxtFileParser(consoleLog);
        List<List<Double>> dataList = new ArrayList<>();
        AppCountService appControler = new AppCountService(consoleLog);
        while (true) {
            consoleLog.printAppMsg("Please enter data file path, or type 'stop' to finish", MessageLevel.INFO);
            Optional<String> fileName = Optional.of(consoleDataLoaderDaoImpl.getData(null));
            if (fileName.get().equals("stop")) {
                break;
            }
            if (fileName.get().endsWith(".txt")) {
                Optional<File> file = Optional.ofNullable(fileDataLoaderDaoImpl.getData(fileName.get()));
                if (file.isPresent()) {
                    Optional<List<Double>> optList = txtFileParser.parseData(file);
                    if (optList.isPresent()) {
                        dataList.add(optList.get());
                        consoleLog.printAppMsg("File loaded successfully:", MessageLevel.INFO);
                    }
                } else {
                    consoleLog.printAppMsg("Wrong file path:", MessageLevel.ERROR);
                }
            } else {
                consoleLog.printAppMsg("Wrong file extension", MessageLevel.ERROR);
            }
        }
        if (dataList.size() >= 2) {
            consoleLog.printAppMsg("Result: " + appControler.proccesAppData(dataList), MessageLevel.INFO);
        }
        countAvergeNumber();
    }
}

