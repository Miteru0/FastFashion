package com.fastfashion;

public class Clothing {

    private String name;
    private String description;
    private String imagePath;
    private String barcode;

    public Clothing() {}

    public Clothing(String name, String description, String imagePath, String barcode) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath(){
        return imagePath;
    }

    public String getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
