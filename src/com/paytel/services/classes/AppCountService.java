package com.paytel.services.classes;

import com.paytel.model.MessageLevel;
import com.paytel.services.CountService;

import java.util.List;

public class AppCountService implements CountService {
    ConsoleLog consoleLog;

    public AppCountService(ConsoleLog consoleLog) {
        this.consoleLog = consoleLog;
    }

    @Override
    public boolean validateAppData(List<List<Double>> list) {
        boolean validationResult = true;
        if (list.size() > 0) {
            int listSize = list.get(0).size();
            for (List<Double> dataList : list) {
                if (dataList.size() != listSize) {
                    validationResult = false;
                    consoleLog.printAppMsg("List sizes not equals", MessageLevel.ERROR);
                }
            }
        } else {
            validationResult = false;
            consoleLog.printAppMsg("Empty input data", MessageLevel.ERROR);
        }
        return validationResult;
    }
}
