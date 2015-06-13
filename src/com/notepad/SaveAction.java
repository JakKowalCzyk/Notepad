package com.notepad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by DK on 2015-06-12.
 */
class SaveAction extends JFrame implements ActionListener{
    public SaveAction(JFileChooser chooser, JTextArea textArea1) {
        this.chooser = chooser;
        this.textArea1 = textArea1;
    }

    public void actionPerformed(ActionEvent e) {
        int result = chooser.showSaveDialog(SaveAction.this);
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = new File(chooser.getSelectedFile() + "");
            setTitle(chooser.getSelectedFile().getName());
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                textArea1.write(writer);
            } catch (IOException ez) {
                ez.printStackTrace();
            }
        }
    }
    private JTextArea textArea1;
    private JFileChooser chooser;
}
