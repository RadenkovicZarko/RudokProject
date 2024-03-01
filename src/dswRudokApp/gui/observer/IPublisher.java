package dswRudokApp.gui.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notyfySubscribers(Object notification);
}
