package dswRudokApp.gui.controller;

import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.ChangeBackgroundJFileChooser;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBackgroundImageAction extends AbstractRudokAction{

    public ChangeBackgroundImageAction()
    {
        putValue(SMALL_ICON,loadIcon("images/promena.png"));
        putValue(NAME,"Change background image");
        putValue(SHORT_DESCRIPTION,"Change background image");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(myTreeNode==null)
        {ErrorFactory.getInstance().generateError(Errori.NOTHING_SELECTED_ERROR); return;}
        if (myTreeNode != null && myTreeNode.getRuNode() instanceof Presentation) {
            ChangeBackgroundJFileChooser changeBackgroundJFileChooser=new ChangeBackgroundJFileChooser();

        }
        else
        {
            ErrorFactory.getInstance().generateError(Errori.WRONG_COMPONENT_SELECTED);

        }

    }
}
