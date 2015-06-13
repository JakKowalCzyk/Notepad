package com.notepad;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by DK on 2015-06-12.
 */
class FileMenuItems extends JFrame {
    public FileMenuItems(JMenu fileMenu, JTextArea textArea1, JFileChooser chooser) {
        this.fileMenu = fileMenu;
        this.textArea1 = textArea1;
        this.chooser = chooser;
    }
    public void setFileMenu(){
        ActionListener SaveAction = new SaveAction(chooser, textArea1);
        ActionListener OpenAction = new OpenAction(chooser, textArea1);
        JMenuItem newItem = new JMenuItem("New");
        fileMenu.add(newItem);
        newItem.addActionListener(e -> {
            int confirm = JOptionPane.showOptionDialog(null, "save?", "not saved", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(confirm == JOptionPane.YES_OPTION) {
                SaveAction.actionPerformed(e);
                textArea1.setText("");
            }
            else textArea1.setText("");
        });
        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        openItem.addActionListener(OpenAction);

        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);
        saveItem.addActionListener(SaveAction);

        JMenuItem endItem = new JMenuItem("End");
        fileMenu.add(endItem);
        endItem.addActionListener(e -> {
            int confirm = JOptionPane.showOptionDialog(null, "save?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(confirm == JOptionPane.YES_OPTION) {
                SaveAction.actionPerformed(e);
                System.exit(0);
            }
            else System.exit(0);
        });
    }
    public JMenu getFileMenu(){
        return fileMenu;
    }
    private JFileChooser chooser;
    private JTextArea textArea1;
    private JMenu fileMenu;
}
