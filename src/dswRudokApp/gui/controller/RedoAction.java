package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRudokAction{
    RedoAction(){
        putValue(SMALL_ICON,loadIcon("images/redo.png"));
        putValue(NAME,"Redo");
        putValue(SHORT_DESCRIPTION,"Redo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCommandManager().doCommand();
    }
}
