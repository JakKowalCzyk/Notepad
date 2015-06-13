package com.notepad;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DK on 2015-06-12.
 */
class FontColor extends JFrame{
    public FontColor(JMenu colorItem, JTextArea textArea1) {
        this.colorItem = colorItem;
        this.textArea1 = textArea1;
    }
    public void setColorItem(){
        ButtonGroup group = new ButtonGroup();
        colorBlack = new JRadioButtonMenuItem("Black");
        colorBlack.setSelected(true);
        colorBlack.addActionListener(e -> {
            this.textArea1.setForeground(Color.BLACK);
        });
        colorBlue = new JRadioButtonMenuItem("Blue");
        colorBlue.addActionListener(e -> {
            this.textArea1.setForeground(Color.BLUE);
        });
        colorRed = new JRadioButtonMenuItem("Red");
        colorRed.addActionListener(e -> {
            this.textArea1.setForeground(Color.RED);
        });
        colorGreen = new JRadioButtonMenuItem("Green");
        colorGreen.addActionListener(e -> {
            this.textArea1.setForeground(Color.GREEN);
        });
        group.add(colorBlack);
        group.add(colorBlue);
        group.add(colorRed);
        group.add(colorGreen);
        colorItem.add(colorBlack);
        colorItem.add(colorBlue);
        colorItem.add(colorRed);
        colorItem.add(colorGreen);
    }
    public JMenu getColorItem(){
        return colorItem;
    }
    private JRadioButtonMenuItem colorBlack, colorBlue, colorRed, colorGreen;
    private JMenu colorItem;
    private JTextArea textArea1;
}
