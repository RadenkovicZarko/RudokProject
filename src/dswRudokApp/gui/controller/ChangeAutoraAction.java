package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.ChangeAutorDialog;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChangeAutoraAction extends AbstractRudokAction implements ActionListener {


    public ChangeAutoraAction()
    {
        putValue(SMALL_ICON,loadIcon("images/promena.png"));
        putValue(NAME,"Change autora");
        putValue(SHORT_DESCRIPTION,"Change autora");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode myTreeNode=(MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(myTreeNode==null)
        {ErrorFactory.getInstance().generateError(Errori.NOTHING_SELECTED_ERROR); return;}
        if(myTreeNode.getRuNode() instanceof Presentation) {

            ChangeAutorDialog changeAutorDialog=new ChangeAutorDialog(myTreeNode);
            changeAutorDialog.setVisible(true);
        }
        else
        {
            ErrorFactory.getInstance().generateError(Errori.WRONG_COMPONENT_SELECTED);
        }



    }




}
