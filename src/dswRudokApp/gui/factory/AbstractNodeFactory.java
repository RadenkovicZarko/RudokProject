package dswRudokApp.gui.factory;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Workspace;
import dswRudokApp.gui.tree.MyTreeNode;

public abstract class AbstractNodeFactory {

    public RuNode getNodeForTree(RuNode ruNode)
    {
        return createNode(ruNode);
    }
    public abstract RuNode createNode(RuNode ruNode);

}
