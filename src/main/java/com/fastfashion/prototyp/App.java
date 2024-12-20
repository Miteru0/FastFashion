package com.fastfashion.prototyp;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.util.*;
import java.util.List;


public class App {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final Map<String, Clothing> clothes = JsonDataImporter.ReadClothingV2("jsons/clothesv2.json");
    private static final List<Question> questions = JsonDataImporter.ReadQuestionV2("jsons/questionv2.json");
    static boolean questionAnswered = false;
    static Question curQuestion;

    public static void main(String[] args) {
        curQuestion = pickQuestion();
        JFrame frame = new JFrame("FastFashion");
        frame.setSize(WIDTH, HEIGHT);
        JTextPane textPane = new JTextPane();
        textPane.setText(curQuestion.getQuestion());
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER); // Set alignment to center
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        textPane.setFont(new Font("Serif", Font.PLAIN, 22));
        textPane.setBounds(50, 200, 300, 200); // Adjust size for multiline text
        textPane.setEditable(false); // Make non-editable

        ImageIcon icon = new ImageIcon("");
        JLabel image = new JLabel(icon);
        image.setBounds(450, 100, 300, 400);

        JLabel scannedClothing = new JLabel("you havent scanned anything yet");
        scannedClothing.setFont(new Font("Serif", Font.PLAIN, 15));
        scannedClothing.setBounds(450, 50, 300, 50);

        JTextField barcodeField = new JTextField();
        barcodeField.setBounds(0, 0, 10, 10);


        frame.add(scannedClothing);
        frame.add(image);
        frame.add(textPane);
        frame.add(barcodeField);
        frame.setLayout(null);



        barcodeField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                String barcode = barcodeField.getText();
                if (!questionAnswered) {
                    if (clothes.containsKey(barcode)) {
                        scannedClothing.setText("you scanned " + clothes.get(barcode).getName());
                    image.setIcon(getImageIcon(clothes.get(barcode).getImagePath()));
                    if (curQuestion.isRight(barcode)) {
                        textPane.setText("you answered right!");
                    } else {
                        textPane.setText(curQuestion.getExplanation());
                    }
                    questionAnswered = true;
                    }
                } else if (!questions.isEmpty() && barcode.equals("4")) {
                    image.setIcon(new ImageIcon(""));
                    scannedClothing.setText("");
                    curQuestion = pickQuestion();
                    textPane.setText(curQuestion.getQuestion());
                    questionAnswered = false;
                }
                else if(questions.isEmpty()){
                    image.setIcon(new ImageIcon(""));
                    scannedClothing.setText("");
                    textPane.setText("there is no questions left!!!!");
                }
                barcodeField.setText("");
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static Question pickQuestion() {
        Random rand = new Random();
        int randomElement = rand.nextInt(questions.size());
        return questions.remove(randomElement);
    }

    private static ImageIcon getImageIcon(String resourcePath) {
        InputStream inputStream = App.class.getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream is null for " + resourcePath);
        }
        ImageIcon imageIcon = new ImageIcon();
        try {
            imageIcon = new ImageIcon(ImageIO.read(inputStream));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return imageIcon;
    }


}
