package com.paytel.services;

import com.paytel.model.MessageLevel;

public interface AppLog {
    void printAppMsg(String errorMsg, MessageLevel messageLevel);
}
