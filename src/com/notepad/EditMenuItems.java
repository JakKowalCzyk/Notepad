package com.notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DK on 2015-06-12.
 */
class EditMenuItems extends JFrame{
    public EditMenuItems(JMenu editMenu, JTextArea textArea1){
        this.editMenu = editMenu;
        this.textArea1 = textArea1;

    }
    public void setEditMenu(){
        UndoManager undoManager = new UndoManager();
        Action UndoAction = new UndoAction(undoManager);
        textArea1.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
        JMenuItem undoItem = new JMenuItem("Undo");
        editMenu.add(undoItem);
        undoItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
        undoItem.addActionListener(UndoAction);

        JMenuItem cutItem = new JMenuItem("Cut");
        editMenu.add(cutItem);
        cutItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        cutItem.addActionListener(new CutSth());

        JMenuItem copyItem = new JMenuItem("Copy");
        editMenu.add(copyItem);
        copyItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
        copyItem.addActionListener(new CopySth());

        JMenuItem pasteItem = new JMenuItem("Paste");
        editMenu.add(pasteItem);
        pasteItem.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
        pasteItem.addActionListener(new PasteSth());
    }
    public JMenu getEditMenu(){
        return editMenu;
    }

    private JMenu editMenu;
    private JTextArea textArea1;

    private class CutSth implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textArea1.cut();
        }
    }
    private class CopySth implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            textArea1.copy();
        }
    }
    private class PasteSth implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            textArea1.paste();
        }
    }
}
