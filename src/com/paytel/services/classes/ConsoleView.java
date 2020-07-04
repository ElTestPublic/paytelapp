package com.paytel.services.classes;

import com.paytel.model.MessageLevel;
import com.paytel.services.AppView;

public class ConsoleView implements AppView {
    @Override
    public void printAppMsg(String msg, MessageLevel messageLevel) {
        System.out.println(msg);
    }
}
