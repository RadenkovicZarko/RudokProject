package dswRudokApp.gui.tree;

import com.sun.source.tree.Tree;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.RuNodeComposite;
import dswRudokApp.gui.model.Workspace;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.ProjectView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class TreeModel extends DefaultTreeModel {


    public TreeModel() {
        super(new MyTreeNode(new Workspace(null,"Workspace")));
    }

}
