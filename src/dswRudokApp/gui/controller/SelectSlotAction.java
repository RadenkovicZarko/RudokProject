package dswRudokApp.gui.controller;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;

import javax.accessibility.AccessibleValue;
import java.awt.event.ActionEvent;

public class SelectSlotAction extends AbstractRudokAction {

    public SelectSlotAction() {
        putValue(SMALL_ICON,loadIcon("images/click.png"));
        putValue(NAME,"Select slot");
        putValue(SHORT_DESCRIPTION,"Select slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        presentationView.startSelectState();

    }
}
