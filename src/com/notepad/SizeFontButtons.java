package com.notepad;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DK on 2015-06-12.
 */
class SizeFontButtons extends JFrame{
    public SizeFontButtons(JTextArea textArea1, JMenu sizeItem) {
        this.textArea1 = textArea1;
        this.sizeItem = sizeItem;
    }
    public void buttons(){
        ButtonGroup group = new ButtonGroup();
        size8 = new JRadioButtonMenuItem("8");
        size8.addActionListener(e -> {
            this.textArea1.setFont(new Font("Century Gothic", Font.BOLD, 8));
        });
        size10 = new JRadioButtonMenuItem("10");
        size10.addActionListener(e -> {
            this.textArea1.setFont(new Font("Century Gothic", Font.BOLD, 10));
        });
        size12 = new JRadioButtonMenuItem("12");
        size12.setSelected(true);
        size12.addActionListener(e -> {
            this.textArea1.setFont(new Font("Century Gothic", Font.BOLD, 12));
        });
        size14 = new JRadioButtonMenuItem("14");
        size14.addActionListener(e -> {
            this.textArea1.setFont(new Font("Century Gothic", Font.BOLD, 14));
        });
        size16 = new JRadioButtonMenuItem("16");
        size16.addActionListener(e -> {
            this.textArea1.setFont(new Font("Century Gothic", Font.BOLD, 16));
        });
        size24 = new JRadioButtonMenuItem("24");
        size24.addActionListener(e -> {
            this.textArea1.setFont(new Font("Century Gothic", Font.BOLD, 24));
        });
        size36 = new JRadioButtonMenuItem("36");
        size36.addActionListener(e -> {
            this.textArea1.setFont(new Font("Century Gothic", Font.BOLD, 36));
        });
        group.add(size8);
        group.add(size10);
        group.add(size12);
        group.add(size14);
        group.add(size16);
        group.add(size24);
        group.add(size36);
        sizeItem.add(size8);
        sizeItem.add(size10);
        sizeItem.add(size12);
        sizeItem.add(size14);
        sizeItem.add(size16);
        sizeItem.add(size24);
        sizeItem.add(size36);
    }
    public JMenu getSizeItem(){
        return sizeItem;
    }

    private JRadioButtonMenuItem size8, size10, size12, size14, size16, size24, size36;
    private JTextArea textArea1;
    private JMenu sizeItem;
}
