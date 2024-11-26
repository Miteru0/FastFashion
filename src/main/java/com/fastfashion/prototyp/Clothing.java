package com.fastfashion.prototyp;

import javax.swing.*;
import java.awt.*;

public class Clothing {
    private String barcode;
    private String name;
    private String imagePath;

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
