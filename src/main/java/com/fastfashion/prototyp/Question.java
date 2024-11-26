package com.fastfashion.prototyp;

public class Question {
    private String question;
    private Clothing rightClothing;
    private String explanation;
    Question(String question, Clothing rightClothing, String explanation){
        this.question = question;
        this.rightClothing = rightClothing;
        this.explanation = explanation;
    }
    public boolean isRight(String barcode){
        return barcode.equals(rightClothing.getBarcode());
    }
    public String getQuestion(){
        return question;
    }
    public String getExplanation(){
        return explanation;
    }
}
