package dswRudokApp.gui.model;

import dswRudokApp.gui.observer.IPublisher;
import dswRudokApp.gui.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Slajd extends RuNode {
    private int redniBr;
    private ArrayList<Slot> listaSlotova=new ArrayList<>();

    public Slajd(String name, RuNode parent) {
        super(name, parent);
    }

    public Slajd(String name, RuNode parent, int redniBr) {
        super(name, parent);
        this.redniBr = redniBr;
    }

    public void addChild(Slot slot) {
        listaSlotova.add(slot);
        notyfySubscribers(new PomocniSlot(slot,"dodata"));
    }

    public void removeChild(Slot s) {
        for (Slot slot:listaSlotova) {
            if(slot.equals(s))
            {
                listaSlotova.remove(slot);
                notyfySubscribers(new PomocniSlot(slot,"obrisan"));
                break;
            }
        }
    }

    public int getRedniBr() {
        return redniBr;
    }

    public void setRedniBr(int redniBr) {
        this.redniBr = redniBr;
    }

    @Override
    public String toString() {
        return getName();
    }

    public ArrayList<Slot> getListaSlotova() {
        return listaSlotova;
    }

    public void setListaSlotova(ArrayList<Slot> listaSlotova) {
        this.listaSlotova = listaSlotova;
    }

    public void setuj()
    {
        ((Presentation)getParent()).setuj();
    }



}
