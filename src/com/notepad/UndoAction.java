package com.notepad;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

/**
 * Created by DK on 2015-06-12.
 */
class UndoAction extends AbstractAction {
    public UndoAction(UndoManager manager) {
        this.manager = manager;
    }
    public void actionPerformed(ActionEvent event){
        manager.undo();
    }

    private UndoManager manager;
}
