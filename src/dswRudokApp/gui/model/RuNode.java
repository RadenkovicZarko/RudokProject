package dswRudokApp.gui.model;

import dswRudokApp.gui.observer.IPublisher;
import dswRudokApp.gui.observer.ISubscriber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class RuNode implements IPublisher, Serializable {
    private String name;
    private RuNode parent;
    transient List<ISubscriber> subscribers=new ArrayList<>();

    public RuNode(String name, RuNode parent) {
        this.name = name;
        this.parent = parent;
    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.notyfySubscribers(name);
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
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
        setuj();
    }
    abstract public void setuj();
    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }
    public void removeAllSubscriber() {
        this.subscribers.clear();
    }

    @Override
    public String toString() {
        return  name +" ";
    }
}
