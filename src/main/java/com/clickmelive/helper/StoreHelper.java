package com.clickmelive.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.clickmelive.model.ElementInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StoreHelper {
    INSTANCE;
    Logger logger = LoggerFactory.getLogger(getClass());
    private static final String DEFAULT_DIRECTORY_PATH = "element-values";
    ConcurrentMap<String, Object> elementMapList;

    StoreHelper() {
        initMap(getFileList());
    }

    private void initMap(File[] fileList) {
        elementMapList = new ConcurrentHashMap<>();
        Type elementType = new TypeToken<List<ElementInfo>>() {
        }.getType();
        Gson gson = new Gson();
        List<ElementInfo> elementInfoList = null;
        for (File file : fileList) {
            try {
                elementInfoList = gson
                        .fromJson(new FileReader(file), elementType);
                elementInfoList.parallelStream()
                        .forEach(elementInfo -> elementMapList.put(elementInfo.getKey(), getElementInfo(elementInfo)));
            } catch (FileNotFoundException e) {
                logger.warn("{} not found", e);
            }
        }
    }

    private ElementInfo getElementInfo(ElementInfo elementInfo) {

        return elementInfo;
    }

    private File[] getFileList() {
        URI uri = null;
        try {
            uri = new URI(this.getClass().getClassLoader().getResource(DEFAULT_DIRECTORY_PATH).getFile());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            logger.error(
                    "File Directory Is Not Found! file name: {}",
                    DEFAULT_DIRECTORY_PATH);
            throw new NullPointerException();
        }
        File[] fileList = new File(uri.getPath())
                .listFiles(pathname -> !pathname.isDirectory() && pathname.getName().endsWith(".json"));
        try {
            logger.info(fileList.length + " adet json dosyası bulunmaktadır.");
        } catch (Exception e) {
            logger.warn(
                    "File Directory Is Not Found! Please Check Directory Location. Default Directory Path = {}",
                    DEFAULT_DIRECTORY_PATH);
            throw new NullPointerException();
        }
        return fileList;
    }

    public void printAllValues() {
        elementMapList.forEach((key, value) -> logger.info("Key = {} value = {}", key, value));
    }


    public ElementInfo findElementInfoByKey(String key) {
        return (ElementInfo) elementMapList.get(key);
    }

    public void saveValue(String key, String value) {
        elementMapList.put(key, value);
    }

    public String getValue(String key) {
        return elementMapList.get(key).toString();
    }

}
