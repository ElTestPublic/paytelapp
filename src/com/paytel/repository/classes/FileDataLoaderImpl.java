package com.paytel.repository.classes;

import com.paytel.repository.DataLoader;

import java.io.File;

public class FileDataLoaderImpl implements DataLoader<File> {

    @Override
    public File getData(String filePath) {
        File dataFile = new File(filePath);
        if (dataFile.exists()) {
            return dataFile;
        }
        return null;
    }

}
