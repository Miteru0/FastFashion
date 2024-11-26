package com.fastfashion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum Data {

    INSTANCE;

    private HashMap<String, ClothingV1> clothes = new HashMap<>();
    private List<Challenge> challenges = new ArrayList<Challenge>();

    public ClothingV1 getClothing(String hashString) {
        if (clothes.containsKey(hashString)) {
            return clothes.get(hashString);
        }
        else {
            return new ClothingV1("404", "not found", "src/main/resources/images/notFound.png", "-1");
        }
    }

    public Challenge getChallenge(int index) {
        if (index < challenges.size()) {
            return challenges.get(index);
        }
        else {
            return new Challenge("Error", "1", Difficulty.EASY);
        }
        
    }

    public void addChallenge(Challenge challenge) {
        challenges.add(challenge);
    }

    public void addClothing(String hashString, ClothingV1 clothing) {
        clothes.put(hashString, clothing);
    }

}
