package dswRudokApp.gui.factory;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.tree.controller.SlotMouseListener;
import dswRudokApp.gui.tree.controller.SlotMouseMotionListener;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.SlajdView;

public class SlajdFactory extends AbstractNodeFactory{
    @Override
    public RuNode createNode(RuNode ruNode) {

        Slajd slajd =new Slajd("Slajd "+(((Presentation)ruNode).getListaRuNodova().size()+1),ruNode,((Presentation)ruNode).getListaRuNodova().size()+1);
        SlajdView slajdView1=new SlajdView(slajd);
        slajdView1.addMouseListener(new SlotMouseListener(slajdView1));
        slajdView1.addMouseMotionListener(new SlotMouseMotionListener(slajdView1));
        SlajdView slajdView2=new SlajdView(slajd,100,75);
        SlajdView slajdView3=new SlajdView(slajd);
        ((Presentation)ruNode).addChild(slajd);
        return slajd;
    }
}
