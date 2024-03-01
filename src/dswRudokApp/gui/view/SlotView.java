package dswRudokApp.gui.view;

import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.model.Type;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.slotContent.MultimediaSlotHandler;
import dswRudokApp.gui.slotContent.SlotHandler;
import dswRudokApp.gui.slotContent.TextSlotHandler;
import dswRudokApp.gui.view.tree.SlajdView;

import java.awt.*;

public class SlotView implements ISubscriber {
    private Slot slot;
    private SlajdView slajdView;
    private SlotHandler slotHandler;
    private int dx1,dy1;
    private int dx2,dy2;


    public SlotView(Slot slot,SlajdView slajdView) {
        this.slot = slot;
        this.slot.addSubscriber(this);
        //this.slot.addSubscriber(slajdView);
        this.slajdView=slajdView;
        if(slot.getType()== Type.Text)
            slotHandler=new TextSlotHandler();
        else
            slotHandler=new MultimediaSlotHandler();

    }

    public SlotView(Slot slot) {
        this.slot = slot;
        this.slot.addSubscriber(this);
        //this.slot.addSubscriber(slajdView);
        slajdView=null;
        if(slot.getType()== Type.Text)
            slotHandler=new TextSlotHandler();
        else
            slotHandler=new MultimediaSlotHandler();
    }

    public void paint(Graphics g)
    {
        Graphics2D graphics2D=(Graphics2D) g;
        ((Graphics2D) g).setStroke(slot.getStroke());
        if(slot.isSelektovan())
        {
            g.setColor(Color.RED);
        }
        else
        {
            g.setColor(slot.getC());
        }

        if(slajdView.getSlajd().getSubscribers().get(1).equals(slajdView)) {
            g.drawRect(slot.getX() * ((SlajdView) slajdView.getSlajd().getSubscribers().get(1)).getWidth() / ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getWidth(), slot.getY() * ((SlajdView) slajdView.getSlajd().getSubscribers().get(1)).getHeight() / ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getHeight(), slot.getWidth() * ((SlajdView) slajdView.getSlajd().getSubscribers().get(1)).getWidth() / ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getWidth(), slot.getHeight() * ((SlajdView) slajdView.getSlajd().getSubscribers().get(1)).getHeight() / ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getHeight());
        }
        else if(slajdView.getSlajd().getSubscribers().get(2).equals(slajdView)) {
            this.dx2=slot.getX()*((SlajdView) slajdView.getSlajd().getSubscribers().get(2)).getWidth() / ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getWidth();
            this.dy2=slot.getY()*((SlajdView) slajdView.getSlajd().getSubscribers().get(2)).getHeight() / ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getHeight();

            g.drawRect(dx2, dy2, slot.getWidth()* ((SlajdView) slajdView.getSlajd().getSubscribers().get(2)).getWidth() / ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getWidth(), slot.getHeight()* ((SlajdView) slajdView.getSlajd().getSubscribers().get(2)).getHeight()/ ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getHeight());
            g.setColor(Color.WHITE);
            g.fillRect(dx2, dy2, slot.getWidth()* ((SlajdView) slajdView.getSlajd().getSubscribers().get(2)).getWidth() / ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getWidth(), slot.getHeight()* ((SlajdView) slajdView.getSlajd().getSubscribers().get(2)).getHeight()/ ((SlajdView) slajdView.getSlajd().getSubscribers().get(0)).getHeight());

            slotHandler.paint(this,graphics2D);
        }
        else {
            g.drawRect(slot.getX(), slot.getY(),  slot.getWidth(), slot.getHeight());
        }

    }
    public boolean elementAt(int x,int y)
    {
        if(x>=slot.getX() && y>=slot.getY() && x<=slot.getX()+ slot.getWidth() && y>=slot.getY() && y<= slot.getY()+ slot.getHeight())
            return true;
        return false;
    }
    @Override
    public void update(Object notification) {
        slajdView.repaint();
    }
    public String getNaziv()
    {
        return slot.toString();
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public SlotHandler getSlotHandler() {
        return slotHandler;
    }

    public void setSlotHandler(SlotHandler slotHandler) {
        this.slotHandler = slotHandler;
    }

    public SlajdView getSlajdView() {
        return slajdView;
    }

    public void setSlajdView(SlajdView slajdView) {
        this.slajdView = slajdView;
    }

    public double getDx1() {
        return dx1;
    }

    public void setDx1(int dx1) {
        this.dx1 = dx1;
    }

    public int getDy1() {
        return dy1;
    }

    public void setDy1(int dy1) {
        this.dy1 = dy1;
    }

    public int getDx2() {
        return dx2;
    }

    public void setDx2(int dx2) {
        this.dx2 = dx2;
    }

    public int getDy2() {
        return dy2;
    }

    public void setDy2(int dy2) {
        this.dy2 = dy2;
    }


}
