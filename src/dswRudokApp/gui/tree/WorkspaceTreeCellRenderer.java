package dswRudokApp.gui.tree;

import dswRudokApp.gui.model.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class WorkspaceTreeCellRenderer extends DefaultTreeCellRenderer {

    public WorkspaceTreeCellRenderer() {
    }

    public Component getTreeCellRendererComponent(JTree tree,Object value,boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);

        if(value instanceof MyTreeNode)
        {
            MyTreeNode myTreeNode=(MyTreeNode) value;

            if (myTreeNode.getRuNode() instanceof Slajd) {
                URL imageURL = getClass().getResource("slike/tdiagram.gif");

                Icon icon = null;
                if (imageURL != null) {

                    icon = new ImageIcon(imageURL);
                }

                setIcon(icon);

            } else if (myTreeNode.getRuNode() instanceof Presentation) {
                URL imageURL = getClass().getResource("slike/presentation4.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
            else if(myTreeNode.getRuNode() instanceof Project)
            {
                URL imageURL = getClass().getResource("slike/project2.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
            else if(myTreeNode.getRuNode() instanceof Workspace)
            {
                URL imageURL = getClass().getResource("slike/workspace2.png");
                Icon icon = null;
                if (imageURL != null)
                    icon = new ImageIcon(imageURL);
                setIcon(icon);
            }
        }

        return this;
    }
}
