package dswRudokApp.gui.model;

import dswRudokApp.gui.observer.IPublisher;
import dswRudokApp.gui.tree.MyTreeNode;

import java.util.ArrayList;

public abstract class RuNodeComposite extends RuNode implements IPublisher {
    ArrayList<RuNode> listaRuNodova=new ArrayList<>();

    public RuNodeComposite(String name, RuNode parent, ArrayList<RuNode> listaRuNodova) {
        super(name, parent);
        this.listaRuNodova = listaRuNodova;
    }

    public RuNodeComposite(String name, RuNode parent) {
        super(name, parent);
        this.listaRuNodova = new ArrayList<>();
    }


    public abstract void addChild(RuNode ruNode);

    public abstract void removeChild(RuNode child);


    public RuNode getChildByName(String name) {
        for (RuNode child: this.getListaRuNodova()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    public ArrayList<RuNode> getListaRuNodova() {
        return listaRuNodova;
    }


    public void setListaRuNodova(ArrayList<RuNode> listaRuNodova) {
        this.listaRuNodova = listaRuNodova;
    }


    public int findIndex(RuNode ruNode)
    {
        for(int i=0;i<listaRuNodova.size();i++)
        {
            if(listaRuNodova.get(i).equals(ruNode))
                return i;
        }
        return -1;
    }


}
