package dswRudokApp.gui.model;


import dswRudokApp.gui.observer.IPublisher;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Workspace extends RuNodeComposite{

    public Workspace(RuNode parent,String naziv) {
        super(naziv, parent);
    }

    @Override
    public void addChild(RuNode ruNode) {
        if(ruNode instanceof Project && !this.listaRuNodova.contains(ruNode))
            getListaRuNodova().add(ruNode);

    }
    public void dodajDete(RuNode ruNode,int index) {
        if(ruNode instanceof Project && !this.listaRuNodova.contains(ruNode))
            getListaRuNodova().add(index,ruNode);

    }

    @Override
    public void removeChild(RuNode child) {
        for (RuNode runode : listaRuNodova) {
            if (child.equals(runode)) {
                listaRuNodova.remove(child);
                break;

            }
        }

    }

    @Override
    public void setuj() {

    }
}
