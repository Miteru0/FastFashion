package com.fastfashion.prototyp;

public class Question {
    private String question;
    private String rightClothingBarcode;
    private String explanation;

    public Question() {}

    Question(String question, String rightClothingBarcode, String explanation){
        this.question = question;
        this.rightClothingBarcode = rightClothingBarcode;
        this.explanation = explanation;
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
