package com.paytel.services.classes;

import com.paytel.model.MessageLevel;
import com.paytel.services.AppLog;

public class ConsoleLog implements AppLog {
    @Override
    public void printAppMsg(String msg, MessageLevel messageLevel) {
        if (MessageLevel.ERROR.equals(messageLevel)) {
            msg = msg.concat("!");
        }
        System.out.println(msg);
    }
}
