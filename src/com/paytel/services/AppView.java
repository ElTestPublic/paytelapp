package com.paytel.services;

import com.paytel.model.MessageLevel;

public interface AppView {
    void printAppMsg(String errorMsg, MessageLevel messageLevel);
}
