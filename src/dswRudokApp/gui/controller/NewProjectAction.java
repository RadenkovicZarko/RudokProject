package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.command.AddCommand;
import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.factory.AbstractNodeFactory;
import dswRudokApp.gui.factory.FactoryManager;
import dswRudokApp.gui.model.*;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.tree.controller.SlotMouseListener;
import dswRudokApp.gui.tree.controller.SlotMouseMotionListener;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.SlajdView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Parameter;

public class NewProjectAction extends AbstractRudokAction{

    public NewProjectAction(){
        putValue(SMALL_ICON,loadIcon("images/new5.png"));
        putValue(NAME,"New Project");
        putValue(SHORT_DESCRIPTION,"New Project");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode myTreeNode=(MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();

        if(myTreeNode==null) {
            ErrorFactory.getInstance().generateError(Errori.NOTHING_SELECTED_ERROR);
            return;
        }
        RuNode parent=myTreeNode.getRuNode();
        if(!(parent instanceof Workspace) && (parent.getParent()==null || myTreeNode==null)) {
            ErrorFactory.getInstance().generateError(Errori.NOTHING_SELECTED_ERROR);
            return;
        }

        AbstractNodeFactory f= FactoryManager.getInstance().getFactory(parent);
        if(f==null)
            return;
        RuNode ruNode=f.getNodeForTree(parent);
        MyTreeNode child=new MyTreeNode(ruNode);
        if(child == null)
            return;

        /*myTreeNode.add(child);
        child.setParent(myTreeNode);*/
        MainFrame.getInstance().getCommandManager().addCommand(new AddCommand(myTreeNode,child));
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

}
