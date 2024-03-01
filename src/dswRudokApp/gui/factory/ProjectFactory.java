package dswRudokApp.gui.factory;

import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Workspace;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

public class ProjectFactory extends AbstractNodeFactory{


    @Override
    public RuNode createNode(RuNode ruNode) {
        Project project=new Project("Project "+(((Workspace)ruNode).getListaRuNodova().size()+1),ruNode);
        ((Workspace)ruNode).addChild(project);
        project.addSubscriber(MainFrame.getInstance().getProjectView());
        return project;
    }
}
