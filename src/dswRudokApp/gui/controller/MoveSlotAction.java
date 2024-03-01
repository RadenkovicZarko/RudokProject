package dswRudokApp.gui.controller;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;

import java.awt.event.ActionEvent;

public class MoveSlotAction extends AbstractRudokAction {
    public MoveSlotAction() {
        putValue(SMALL_ICON,loadIcon("images/move.png"));
        putValue(NAME,"Move slot");
        putValue(SHORT_DESCRIPTION,"Move slot");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        presentationView.startMoveSlotState();

    }
}
