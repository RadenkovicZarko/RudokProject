package dswRudokApp.gui.factory;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.tree.PresentationView;

public class PresentationFactory extends AbstractNodeFactory{


    @Override
    public RuNode createNode(RuNode ruNode) {

        Presentation presentation=new Presentation("Presentation "+(((Project)ruNode).getListaRuNodova().size()+1),ruNode,"Autor");
        PresentationView presentationView=new PresentationView(presentation);
        ((Project)ruNode).addChild(presentation);
        return presentation;
    }
}
