package com.fastfashion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastfashion.prototyp.Clothing;
import com.fastfashion.prototyp.Question;


public class JsonDataImporter {

    Data database = Data.INSTANCE;

    public static Map<String, Clothing> ReadClothingV2(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Clothing> hashMap = new HashMap<>();
        try {
            List<Clothing> clothes = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Clothing>>(){});

            for (Clothing clothing : clothes) {
                hashMap.put(clothing.getBarcode(), clothing);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static List<Question> ReadQuestionV2(String jsonFilePath) {
        List<Question> list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Question> questions = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Question>>(){});

            for (Question question : questions) {
                list.add(question);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    

    public void ReadClothing(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<ClothingV1> clothes = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<ClothingV1>>(){});

            for (ClothingV1 clothing : clothes) {
                database.addClothing(clothing.getBarcode(), clothing);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadChallenge(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Challenge> challenges = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Challenge>>(){});

            for (Challenge challenge : challenges) {
                database.addChallenge(challenge);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
