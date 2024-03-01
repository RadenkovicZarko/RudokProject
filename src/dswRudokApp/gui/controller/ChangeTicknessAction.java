package dswRudokApp.gui.controller;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.view.ChangeThicknessDialog;
import dswRudokApp.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class ChangeTicknessAction extends AbstractRudokAction{
    public ChangeTicknessAction()
    {
        putValue(SMALL_ICON,loadIcon("images/width.png"));
        putValue(NAME,"Change stroke");
        putValue(SHORT_DESCRIPTION,"Change stroke");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        ChangeThicknessDialog changeThicknessDialog=new ChangeThicknessDialog(presentation);
        changeThicknessDialog.setVisible(true);


    }
}
