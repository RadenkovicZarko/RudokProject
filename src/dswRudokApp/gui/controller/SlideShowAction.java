package dswRudokApp.gui.controller;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;

import java.awt.event.ActionEvent;

public class SlideShowAction extends AbstractRudokAction{
    public SlideShowAction() {
        putValue(SMALL_ICON,loadIcon("images/slideShow.png"));
        putValue(NAME,"Start slide show");
        putValue(SHORT_DESCRIPTION,"Start slide show");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index=MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        presentationView.startSlideShowState();
        presentationView.showContent();
    }
}
