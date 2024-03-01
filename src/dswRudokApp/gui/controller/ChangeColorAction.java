package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;

import javax.management.AttributeValueExp;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChangeColorAction extends AbstractRudokAction {
    public ChangeColorAction() {
        putValue(SMALL_ICON,loadIcon("images/color.png"));
        putValue(NAME,"Change color");
        putValue(SHORT_DESCRIPTION,"Change color");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        JColorChooser jColorChooser=new JColorChooser();

        Color c=JColorChooser.showDialog(MainFrame.getInstance(),"Boja",Color.WHITE);
        presentation.setColor(c);

    }
}
