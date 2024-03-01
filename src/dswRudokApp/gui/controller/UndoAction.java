package dswRudokApp.gui.controller;

import dswRudokApp.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRudokAction{
    UndoAction(){
        putValue(SMALL_ICON,loadIcon("images/undo.png"));
        putValue(NAME,"Undo");
        putValue(SHORT_DESCRIPTION,"Undo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().undoCommand();
    }
}
