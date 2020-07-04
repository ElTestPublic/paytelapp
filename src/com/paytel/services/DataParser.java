package com.paytel.services;

import java.util.List;
import java.util.Optional;

public interface DataParser<T> {
    Optional<List<Double>> parseData(Optional<T> type);
}