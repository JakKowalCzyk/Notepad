package com.notepad;


import javax.swing.*;
import javax.swing.undo.UndoManager;

/**
 * Created by DK on 2015-06-11.
 */
class NoteFrame extends JFrame {
    public JTextArea textArea1;
    private JPanel panel1;
    private JPopupMenu popup;

    public NoteFrame() {
        JFileChooser chooser = new JFileChooser();
        UndoManager undoManager = new UndoManager();
        Action UndoAction = new UndoAction(undoManager);
        setTitle("Notepad");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        FileMenuItems fileMenuItems = new FileMenuItems(fileMenu, textArea1, chooser);
        fileMenuItems.setFileMenu();
        fileMenuItems.getFileMenu();
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        EditMenuItems editMenuItems = new EditMenuItems(editMenu, textArea1);
        editMenuItems.setEditMenu();
        editMenuItems.getEditMenu();
        JMenu fontMenu = new JMenu("Font");
        menuBar.add(fontMenu);
        JMenu sizeItem = new JMenu("Size");
        fontMenu.add(sizeItem);
        JMenu colorItem = new JMenu("Color");
        fontMenu.add(colorItem);
        SizeFontButtons fontButtons = new SizeFontButtons(textArea1, sizeItem);
        fontButtons.buttons();
        fontButtons.getSizeItem();
        FontColor colors = new FontColor(colorItem, textArea1);
        colors.setColorItem();
        colors.getColorItem();

        setContentPane(panel1);
        pack();
    }
}

