package dswRudokApp.gui.view;

import dswRudokApp.gui.controller.UndoAction;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JToolBar {


    public Toolbar()
    {
        super(HORIZONTAL);
        setMaximumSize(new Dimension(300,12));
        setFloatable(false);
        removeAll();
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getDeleteAction());
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        add(MainFrame.getInstance().getActionManager().getOpenPresentationAction());
        add(MainFrame.getInstance().getActionManager().getSaveWorkspaceAction());
        add(MainFrame.getInstance().getActionManager().getSaveAction());
        add(MainFrame.getInstance().getActionManager().getSavePresentationAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getInfoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getShareAction());

    }



    /*public void setEditMode()
    {

        addSeparator();
        add(MainFrame.getInstance().getActionManager().getSlideShowAction());
    }
    public void setSlideShowMode()
    {
        this.removeAll();
        add(MainFrame.getInstance().getActionManager().getExitSlideShowAction());

    }*/
}
