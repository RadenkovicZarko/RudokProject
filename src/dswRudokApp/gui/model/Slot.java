package dswRudokApp.gui.model;

import dswRudokApp.gui.observer.IPublisher;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.serialization.SerializableStrokeAdapter;
import dswRudokApp.gui.view.tree.SlajdView;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Slot implements IPublisher, Serializable {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color c;
    private SerializableStrokeAdapter stroke;
    transient private List<ISubscriber> subscribers=new ArrayList<>();
    private Slajd parent=null;
    private boolean selektovan=false;
    private boolean pomera=false;
    private Type type;
    private String content;


    public Slot(int x, int y, int width, int height,Color c,Stroke s,Type type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Color color=c;
        this.c = color;
        this.stroke=new SerializableStrokeAdapter(s);
        this.type=type;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers==null)
            this.subscribers=new ArrayList<>();
        if(this.subscribers.contains((sub)))
            return ;

        this.subscribers.add(sub);

    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub==null || this.subscribers==null)
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notyfySubscribers(Object notification) {
        if(notification==null || this.subscribers==null)
            return;
        for (ISubscriber listener : subscribers) {
            {
                listener.update(notification);
            }
        }
        if(!(notification instanceof Boolean))
            setuj();
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Stroke getStroke() {
        return stroke.getStroke();
    }



    public Slajd getParent() {
        return parent;
    }

    public void setParent(Slajd parent) {
        this.parent = parent;
    }

    public void setKordinate(int x,int y)
    {
        this.x=x;
        this.y=y;
        notyfySubscribers(this);
    }

    public boolean isSelektovan() {
        return selektovan;
    }

    public boolean isPomera() {
        return pomera;
    }

    public void setPomera(boolean pomera) {
        this.pomera = pomera;
    }


    public void setSelektovan(boolean selektovan) {
        this.selektovan = selektovan;
        notyfySubscribers(selektovan);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setuj()
    {
        ((Slajd)parent).setuj();
    }
}
