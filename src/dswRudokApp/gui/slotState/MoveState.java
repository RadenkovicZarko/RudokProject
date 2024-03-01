package dswRudokApp.gui.slotState;

import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.SlotView;
import dswRudokApp.gui.view.tree.SlajdView;

import java.awt.*;
import java.util.Iterator;

public class MoveState extends State{



    @Override
    public void mouseDrag(SlajdView slajdView, int x, int y) {
        double prevX=slajdView.getPoint().getX();
        double prevY=slajdView.getPoint().getY();

        Iterator<Slot> iterator=slajdView.getSlajd().getListaSlotova().iterator();
        Slot s=null;
        Slajd slajd=slajdView.getSlajd();
        boolean pom=false;

        for (Slot slot:slajd.getListaSlotova()) {
            if(slot.isPomera())
            {pom=true;
            s=slot;
            break;}
        }

        if(pom==false)
        {
            while(iterator.hasNext())
            {
                Slot slot= iterator.next();
                if(((SlotView)slot.getSubscribers().get(0)).elementAt((int)prevX,(int)prevY))
                {
                    s=slot;
                    break;
                }
            }
            if(s==null) {
                return;
            }
            s.setPomera(true);
        }

        slajdView.setPoint(new Point(x,y));
        if(x+s.getWidth()<=slajdView.getWidth() && x>= 0 && y+s.getHeight()<=slajdView.getHeight() && y>=0)
        s.setKordinate(x,y);
    }



}
