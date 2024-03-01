package dswRudokApp.gui.slotState;

import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.SlotView;
import dswRudokApp.gui.view.tree.SlajdView;

import java.util.ArrayList;
import java.util.Iterator;

public class DeleteState extends State{

    @Override
    public void mousePressed(SlajdView slajdView, int x, int y) {
        Iterator<Slot> iterator=slajdView.getSlajd().getListaSlotova().iterator();
        while(iterator.hasNext())
        {
            Slot slot= iterator.next();
            if(((SlotView)slot.getSubscribers().get(0)).elementAt(x,y))
            {slajdView.getSlajd().removeChild(slot);break;}
        }

    }

}
