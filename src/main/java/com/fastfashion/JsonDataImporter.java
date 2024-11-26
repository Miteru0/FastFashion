package com.fastfashion;

import java.util.List;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonDataImporter {

    Data database = Data.INSTANCE;



    public void ReadClothing(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Clothing> clothes = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Clothing>>(){});

            for (Clothing clothing : clothes) {
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
