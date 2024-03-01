package dswRudokApp.gui.slotState;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.tree.SlajdView;

import java.awt.*;

public class AddState extends State{
    @Override
    public void mousePressed(SlajdView slajdView,int x,int y) {

        Presentation presentation =(Presentation)slajdView.getSlajd().getParent();
        Slot slot=new Slot(x,y,50,100,presentation.getColor(), presentation.getStroke(),presentation.getType());
        slot.setParent(slajdView.getSlajd());
        slajdView.getSlajd().addChild(slot);

    }



}
