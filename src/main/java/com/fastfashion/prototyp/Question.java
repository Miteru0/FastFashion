package com.fastfashion.prototyp;

public class Question {
    enum Difficulty{
        easy, medium, hard
    }
    private Difficulty difficulty;
    private String question;
    private String rightClothingBarcode;
    private String explanation;

    public Question() {}

    Question(String question, String rightClothingBarcode, String explanation, Difficulty difficulty){
        this.question = question;
        this.rightClothingBarcode = rightClothingBarcode;
        this.explanation = explanation;
        this.difficulty = difficulty;
    }

    public boolean isRight(String barcode){
        return barcode.equals(rightClothingBarcode);
    }

    public String getQuestion(){
        return question;
    }

    public String getExplanation(){
        return explanation;
    }

    public String getRightClothingBarcode() {
        return rightClothingBarcode;
    }
}
