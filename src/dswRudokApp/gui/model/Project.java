package dswRudokApp.gui.model;


import dswRudokApp.gui.observer.IPublisher;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class Project extends RuNodeComposite {

    private File projectFile;
    private boolean change;
    public Project(String name, RuNode parent) {
        super(name, parent);this.projectFile=null;
        change=false;
    }

    @Override
    public void addChild(RuNode ruNode) {
        if(ruNode instanceof Presentation && !this.listaRuNodova.contains(ruNode))
            getListaRuNodova().add(ruNode);

        this.notyfySubscribers(new PomocnaPrezentacija((Presentation) ruNode,"dodat"));
    }

    @Override
    public void removeChild(RuNode child) {
        for (RuNode runode:listaRuNodova) {
            if(child.equals(runode))
            {
                listaRuNodova.remove(child);

                break;

            }
        }
        this.notyfySubscribers(new PomocnaPrezentacija((Presentation) child,"uklonjen"));
    }


    public void dodajSerovan(RuNode ruNode) {
        if(ruNode instanceof Presentation)
            getListaRuNodova().add(ruNode);
        this.notyfySubscribers(null);
    }


    public void izbrisiSerovan(RuNode child) {
        for (RuNode runode:listaRuNodova) {
            if(child.equals(runode))
            {
                listaRuNodova.remove(child);

                break;

            }
        }
        this.notyfySubscribers(null);
    }

    public int findIndexByChild(Presentation node){
        if(this.getListaRuNodova().contains(node))
        {
            return this.getListaRuNodova().indexOf(node);
        }
        return -1;
    }

    @Override
    public String getName() {
        return super.getName();

    }

    @Override
    public void setName(String name) {
        super.setName(name);
        this.notyfySubscribers(name);

    }


    @Override
    public String toString() {
        return (getName()+(change?"* ":""));
    }

    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    public boolean isChanged() {
        return change;
    }


    public void setChanged(boolean changed) {
        if (this.change!=changed){
            this.change=changed;
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }
    }
    public void setuj()
    {
        setChanged(true);
    }

}
