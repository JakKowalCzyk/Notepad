package com.notepad;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by DK on 2015-06-12.
 */
class OpenAction extends JFrame implements ActionListener{
    public OpenAction(JFileChooser chooser, JTextArea textArea1) {
        this.chooser = chooser;
        this.textArea1 = textArea1;
    }
    public void actionPerformed(ActionEvent e) {
        chooser.setFileFilter(new FileNameExtensionFilter("Pliki txt", "txt"));
        int result = chooser.showOpenDialog(OpenAction.this);
        if(result==JFileChooser.APPROVE_OPTION) {
            textArea1.setText("");
            File file = chooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea1.append(line);
                    textArea1.append("\n");
                }
            } catch (FileNotFoundException ec) {
                ec.printStackTrace();
            } catch (IOException ec) {
                ec.printStackTrace();
            }
        }
    }
    private JTextArea textArea1;
    private JFileChooser chooser;
}
