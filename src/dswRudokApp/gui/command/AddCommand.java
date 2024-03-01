package dswRudokApp.gui.command;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.RuNodeComposite;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AddCommand extends AbstractCommand{

    MyTreeNode parent;
    MyTreeNode node;
    List<MyTreeNode> listaDodatih=new ArrayList<>();
    public AddCommand(MyTreeNode parent, MyTreeNode node)
    {
        this.parent=parent;
        this.node=node;
    }

    @Override
    public void doCommand() {

            if(parent.getRuNode() instanceof Presentation)
            {
                MyTreeNode workspace=(MyTreeNode) parent.getParent().getParent();
                for(int i=0;i<workspace.getChildCount();i++)
                {
                    MyTreeNode project=(MyTreeNode) workspace.getChildAt(i);
                    for (int j=0;j<project.getChildCount();j++)
                    {
                        MyTreeNode presentation=(MyTreeNode) project.getChildAt(j);
                        if(presentation.getRuNode().equals(parent.getRuNode()))
                        {
                            ((Presentation) parent.getRuNode()).addChild(node.getRuNode());
                            (node.getRuNode()).setParent(parent.getRuNode());
                            MyTreeNode sharedSlide=new MyTreeNode(node.getRuNode());
                            presentation.add(sharedSlide);
                            sharedSlide.setParent(presentation);
                            listaDodatih.add(sharedSlide);
                        }
                    }
                }
            }
            else
            {
                (node.getRuNode()).setParent(parent.getRuNode());
                ((RuNodeComposite) parent.getRuNode()).addChild(node.getRuNode());
                parent.add(node);
                node.setParent(parent);
            }
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());

    }

    @Override
    public void undoCommand() {

        if(parent.getRuNode() instanceof Presentation) {

            MyTreeNode workspace = (MyTreeNode) parent.getParent().getParent();
            for(MyTreeNode child : listaDodatih){
                MyTreeNode p=child.getParent();
                p.remove(child);
                child.setParent(null);
                ((RuNodeComposite) p.getRuNode()).removeChild(child.getRuNode());
                child.getRuNode().setParent(null);
            }
            listaDodatih.clear();
        }
        else
        {
            parent.remove(node);
            node.setParent(null);
            ((RuNodeComposite) parent.getRuNode()).removeChild(node.getRuNode());
            node.getRuNode().setParent(null);
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getSplitPane().getLeftComponent());
        if(node.getRuNode().equals(MainFrame.getInstance().getProjectView().getProject()))
        {
            MainFrame.getInstance().getProjectView().removeAll();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getSplitPane().getRightComponent());
        }
    }
}
