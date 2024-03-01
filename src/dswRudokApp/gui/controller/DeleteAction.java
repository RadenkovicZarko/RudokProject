package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.command.DeleteCommand;
import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.*;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DeleteAction extends AbstractRudokAction{

    public DeleteAction() {
        putValue(SMALL_ICON,loadIcon("images/bin3.png"));
        putValue(NAME,"Delete");
        putValue(SHORT_DESCRIPTION,"Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode myTreeNode=(MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(myTreeNode==null) {
            ErrorFactory.getInstance().generateError(Errori.NOTHING_SELECTED_ERROR);
            return;
        }
        if(myTreeNode.getRuNode() instanceof Workspace)
        {
            ErrorFactory.getInstance().generateError(Errori.NO_PERMISSION_ERROR);
            return;
        }
        MyTreeNode parent=myTreeNode.getParent();
        if(myTreeNode.getRuNode().getParent()==null)
        {
            ErrorFactory.getInstance().generateError(Errori.NOTHING_SELECTED_ERROR);
            return;
        }
        removeProject(myTreeNode);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }


    private void removeProject(MyTreeNode myTreeNode)
    {
        MyTreeNode parent = myTreeNode.getParent(); // parent MYTN
        RuNodeComposite ruNode = (RuNodeComposite) parent.getRuNode(); // parent RUN
        RuNode ruNodeZaBrisanje = myTreeNode.getRuNode();
        /*parent.remove(myTreeNode); //
        myTreeNode.setParent(null);
        ruNode.removeChild(ruNodeZaBrisanje); //
        ruNodeZaBrisanje.setParent(null);*/

        MainFrame.getInstance().getCommandManager().addCommand(new DeleteCommand(parent,myTreeNode));


        MainFrame.getInstance().getMyTree().setSelectionPath(null);

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());

    }
}
