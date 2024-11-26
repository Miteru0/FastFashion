package com.fastfashion;

public class Challenge {

    private String question;
    private String solutionId;
    private Difficulty difficulty;
    
    public Challenge() {}

    public Challenge(String question, String solutionId, Difficulty difficulty) {
        this.question = question;
        this.solutionId = solutionId;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getSolutionId() {
        return solutionId;
    }

    public boolean isRightAnswer(String solutionId) {
        return this.solutionId.equals(solutionId);
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

}
