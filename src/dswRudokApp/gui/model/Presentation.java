package dswRudokApp.gui.model;

import dswRudokApp.gui.observer.IPublisher;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.serialization.SerializableStrokeAdapter;
import dswRudokApp.gui.view.tree.SlajdView;


import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Presentation extends RuNodeComposite  {
    private String nazivAutora;
    private String urlSlike;
    private Color color=Color.black;
    private SerializableStrokeAdapter stroke=new SerializableStrokeAdapter(new BasicStroke(5f));
    private int tickness=5;
    private Type type=Type.Text;
    private List<Project> listaProjekata=new ArrayList<>();



    public Presentation(String name, RuNode parent, String naziv) {
        super(name, parent);
        this.nazivAutora = naziv;
        this.urlSlike = "src\\dswRudokApp\\gui\\controller\\images\\pozadina.jpg";

    }

    @Override
    public void addChild(RuNode ruNode) {
        if(ruNode instanceof Slajd && !this.listaRuNodova.contains(ruNode)) {
            getListaRuNodova().add(ruNode);
            Slajd slajd=(Slajd) ruNode;
            this.notyfySubscribers(slajd);
        }
        ((Project)getParent()).setChanged(true);
    }

    public void dodajNaIndeks(int indeks,RuNode ruNode) {
        if(ruNode instanceof Slajd && !this.listaRuNodova.contains(ruNode)) {
            getListaRuNodova().add(indeks,ruNode);
            Slajd slajd=(Slajd) ruNode;
            this.notyfySubscribers(slajd);
        }
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

        this.notyfySubscribers(new Dimension());
    }


    public String getNazivAutora() {
        return nazivAutora;
    }

    public void setNazivAutora(String nazivAutora) {
        this.nazivAutora = nazivAutora;
        this.notyfySubscribers(new Object());
    }

    public String getUrlSlike() {
        return urlSlike;
    }

    public void setUrlSlike(String urlSlike) {
        this.urlSlike = urlSlike;
        this.notyfySubscribers(new String("URL"));
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stroke getStroke() {
        return stroke.getStroke();
    }

    public void setStroke() {
        if(((BasicStroke)stroke.getStroke()).getDashArray()==null ) {
            this.stroke.setStroke(new BasicStroke(tickness ,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, new float[]{9}, 0.0f));
        }
        else
            this.stroke.setStroke(new BasicStroke(tickness));

    }


    public int getTickness() {
        return tickness;
    }

    public void setTickness(int tickness) {
        this.tickness = tickness;
        if(((BasicStroke)stroke.getStroke()).getDashArray()!=null ) {
            this.stroke.setStroke(new BasicStroke(tickness ,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, new float[]{9}, 0.0f));
        }
        else
            this.stroke.setStroke(new BasicStroke(tickness));
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Project> getListaProjekata() {
        return listaProjekata;
    }

    public void setListaProjekata(List<Project> listaProjekata) {
        this.listaProjekata = listaProjekata;
    }

    public void setuj()
    {
        ((Project)getParent()).setuj();
        for(Project p:listaProjekata)
            p.setuj();
    }

}
