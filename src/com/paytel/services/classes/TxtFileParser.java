package com.paytel.services.classes;

import com.paytel.services.DataParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class TxtFileParser implements DataParser<File> {

        @Override
        public Optional<List<Double>> parseData(Optional<File> file) {
            String stringData="";
            List<String> stringList;
            List<Double> doubleList = new ArrayList<>();
            if(!file.isPresent()){
                return null;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file.get()));
                String line = bufferedReader.readLine();
                stringData = line;
                while ((bufferedReader.readLine()) != null){
                    stringData+=line;
                    line = bufferedReader.readLine();
                }
            } catch (FileNotFoundException e) {
               e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!stringData.isBlank()){
                stringList = new ArrayList<String>(Arrays.asList(stringData.split(",")));
            }else{
                return null;
            }
            for(String s : stringList) {
                doubleList.add(Double.parseDouble(s));
            }
            return Optional.of(doubleList);
        }
    }

