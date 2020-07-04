package com.paytel.services;

import java.util.ArrayList;
import java.util.List;


public interface CountService {

    default double proccesAppData(List<List<Double>> list) {
        List<Double> resultList = new ArrayList<>();
        if (validateAppData(list)) {
            resultList.addAll(list.get(0));
            for (int i = 0; i < list.get(0).size(); i++) {
                for (List<Double> dataList : list) {
                    if (resultList.get(i) < dataList.get(i)) {
                        resultList.set(i, dataList.get(i));
                    }
                }
            }
            return resultList.stream().mapToDouble(a -> a).average().orElse(0);
        } else return 0;
    }


    boolean validateAppData(List<List<Double>> list);
}

