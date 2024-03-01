package dswRudokApp.gui.command;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;

public class RenameCommand extends AbstractCommand{
    private MyTreeNode child;
    private String name;
    private String newName;
    public RenameCommand(MyTreeNode child, String name,String newName) {
        this.child = child;
        this.name = name;
        this.newName=newName;
    }

    @Override
    public void doCommand() {

        child.getRuNode().setName(newName);
        child.setName(newName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        child.getRuNode().setName(name);
        child.setName(name);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }
}
