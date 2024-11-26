package com.fastfashion.prototyp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonDataImporter {

    private static InputStream getResourceAsStream(String resourcePath) {
        InputStream inputStream = JsonDataImporter.class.getClassLoader().getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream is null for " + resourcePath);
        }
        return inputStream;
    }

    public static Map<String, Clothing> ReadClothingV2(String resourcePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Clothing> hashMap = new HashMap<>();
        try {
            InputStream inputStream = getResourceAsStream(resourcePath);
            List<Clothing> clothes = objectMapper.readValue(inputStream, new TypeReference<List<Clothing>>() {});
            for (Clothing clothing : clothes) {
                hashMap.put(clothing.getBarcode(), clothing);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return hashMap;
    }

    public static List<Question> ReadQuestionV2(String resourcePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> list = new ArrayList<>();
        try {
            InputStream inputStream = getResourceAsStream(resourcePath);
            list = objectMapper.readValue(inputStream, new TypeReference<List<Question>>() {});

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
