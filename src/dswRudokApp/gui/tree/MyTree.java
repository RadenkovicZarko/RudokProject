package dswRudokApp.gui.tree;

import com.sun.source.tree.Tree;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.RuNodeComposite;
import dswRudokApp.gui.tree.controller.MyMouseListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyTree extends JTree {
    public MyTree() {
        addTreeSelectionListener(new WorkspaceTreeSelectionListener());
        setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
        setCellRenderer(new WorkspaceTreeCellRenderer());
        addMouseListener(new MyMouseListener());
        setEditable(true);
    }

}
