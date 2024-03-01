package dswRudokApp.gui.slotState;

import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.SlotView;
import dswRudokApp.gui.view.tree.SlajdView;

import java.util.Iterator;

public class SelectionState extends State{

    private SlotView selektovaniSlot;

    @Override
    public void mousePressed(SlajdView slajdView, int x, int y) {
        super.mousePressed(slajdView, x, y);

        Iterator<Slot> iterator=slajdView.getSlajd().getListaSlotova().iterator();
        while(iterator.hasNext())
        {
            Slot slot= iterator.next();
            if(((SlotView)slot.getSubscribers().get(0)).elementAt(x,y))
            {
                if(slot.isSelektovan()==false)
                {slot.setSelektovan(true); selektovaniSlot=((SlotView)slot.getSubscribers().get(0));}
                else
                {slot.setSelektovan(false); selektovaniSlot=null;}

            }
            else
            {
                if(slot.isSelektovan()==true)
                {slot.setSelektovan(false); selektovaniSlot=null;}
            }
        }

    }

    public SlotView getSelektovaniSlot() {
        return selektovaniSlot;
    }

    public void setSelektovaniSlot(SlotView selektovaniSlot) {
        this.selektovaniSlot = selektovaniSlot;
    }
}
