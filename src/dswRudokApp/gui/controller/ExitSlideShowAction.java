package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;

import java.awt.event.ActionEvent;

public class ExitSlideShowAction extends AbstractRudokAction{

    public ExitSlideShowAction() {
        putValue(SMALL_ICON,loadIcon("images/exit.png"));
        putValue(NAME,"Start slide show");
        putValue(SHORT_DESCRIPTION,"Start slide show");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index=MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        presentationView.startEditState();
        presentationView.showContent();

    }
}
