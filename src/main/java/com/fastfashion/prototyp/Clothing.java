package com.fastfashion.prototyp;

public class Clothing {
    private String barcode;
    private String name;
    private String imagePath;

    public Clothing() {}

    Clothing(String barcode, String name, String imagePath) {
        this.barcode = barcode;
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getBarcode(){
        return barcode;
    }
    public String getName(){
        return name;
    }
    public String getImagePath(){
        return imagePath;
    }

}
