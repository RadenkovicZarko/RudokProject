package dswRudokApp.gui.controller;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;

import java.awt.event.ActionEvent;

public class RemoveSlotAction extends AbstractRudokAction{
    public RemoveSlotAction() {
        putValue(SMALL_ICON,loadIcon("images/eraser.png"));
        putValue(NAME,"Delete slot");
        putValue(SHORT_DESCRIPTION,"Delete slot");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        presentationView.startDeleteState();

    }
}
