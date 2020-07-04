package com.paytel.repository;

public interface DataLoader<T> {
    T getData(String dataName);
}

