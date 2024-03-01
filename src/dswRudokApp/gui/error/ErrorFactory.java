package dswRudokApp.gui.error;

import dswRudokApp.gui.observer.IPublisher;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.view.MainFrame;

import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class ErrorFactory implements IPublisher {
    private static ErrorFactory instance = null;
    private List<ISubscriber> subscribers=new ArrayList<>();

    private ErrorFactory() {
    }
    public static ErrorFactory getInstance(){
        if (instance == null) {
            instance = new ErrorFactory();
        }
        return instance;
    }
    public void generateError(Errori errori)
    {

        if(errori.equals(Errori.EMPTY_NAME))
        {
            this.notyfySubscribers(new MyError("Nije uneto ispravno ime"));
        }
        else if(errori.equals(Errori.NOTHING_SELECTED_ERROR))
        {
            this.notyfySubscribers(new MyError("Nista nije selektovano"));
        }
        else if(errori.equals(Errori.WRONG_COMPONENT_SELECTED))
        {
            this.notyfySubscribers(new MyError("Pogresna komponenta u stablu je selektovana"));
        }
        else
        {
            this.notyfySubscribers(new MyError("Nije dozvoljena akcija"));
        }

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
        for(ISubscriber listener:subscribers)
            listener.update(notification);

    }




    public static void setInstance(ErrorFactory instance) {
        ErrorFactory.instance = instance;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
