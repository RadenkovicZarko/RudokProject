package dswRudokApp.gui.controller;

import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.ChangeAutorDialog;
import dswRudokApp.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class ChangeStrokeAction extends AbstractRudokAction{
    public ChangeStrokeAction()
    {
        putValue(SMALL_ICON,loadIcon("images/stroke.png"));
        putValue(NAME,"Change stroke");
        putValue(SHORT_DESCRIPTION,"Change stroke");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        presentation.setStroke();


    }
}
