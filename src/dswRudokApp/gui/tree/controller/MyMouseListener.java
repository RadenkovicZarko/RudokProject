package dswRudokApp.gui.tree.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        MyTreeNode myTreeNode= (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(myTreeNode == null || !(myTreeNode.getRuNode() instanceof Project))
            return;
        if(e.getClickCount()==2 && myTreeNode.getRuNode().getParent()!=null)
        {
            MainFrame.getInstance().getProjectView().setProject((Project) myTreeNode.getRuNode());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
