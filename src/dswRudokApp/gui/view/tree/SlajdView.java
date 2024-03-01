package dswRudokApp.gui.view.tree;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.*;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.SlotView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SlajdView extends JPanel implements ISubscriber {

    private Slajd slajd;
    //private MiniSlajdView miniSlajdView;
    private int br;
    private ArrayList<SlotView> listaSlotView=new ArrayList<>();
    private Point point=new Point(0,0);


    public SlajdView(Slajd slajd) {

        this.slajd=slajd;
        this.slajd.addSubscriber(this);
        this.setLayout(new BorderLayout());
        //slajd.getParent().addSubscriber(this);
        this.br=slajd.getSubscribers().size();
        this.setPreferredSize(new Dimension(MainFrame.getInstance().getjPanel().getWidth()-200,MainFrame.getInstance().getjPanel().getHeight()-100));
        this.setMinimumSize(new Dimension(MainFrame.getInstance().getjPanel().getWidth()-200,MainFrame.getInstance().getjPanel().getHeight()-100));
        this.setMaximumSize(new Dimension(MainFrame.getInstance().getjPanel().getWidth()-200,MainFrame.getInstance().getjPanel().getHeight()-100));
        paint();
    }
    public SlajdView(Slajd slajd,int x,int y) {

        this.slajd=slajd;
        this.slajd.addSubscriber(this);
        this.setLayout(new BorderLayout());
        //this.miniSlajdView=new MiniSlajdView(slajd);
        //slajd.getParent().addSubscriber(this);
        this.br=slajd.getSubscribers().size();
        this.setMinimumSize(new Dimension(x,y));
        this.setPreferredSize(new Dimension(x,y));
        this.setMaximumSize(new Dimension(x,y));
        paint();
    }

    private void paint()
    {
        this.removeAll();
        RuNode presentation= slajd.getParent();
        Presentation presentation1=(Presentation)presentation;
        String str=presentation1.getNazivAutora();
        JLabel jLabel=new JLabel(""+slajd.getRedniBr());
        jLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        this.add(jLabel,BorderLayout.PAGE_END);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getProjectView());
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof PomocniSlot && ((PomocniSlot)notification).getString().equals("dodata"))
        {
            //slot.set
            SlotView slotView=new SlotView((Slot) ((PomocniSlot) notification).getSlot(),this);
            listaSlotView.add(slotView);
            this.repaint();
        }
        else if(notification instanceof PomocniSlot)
        {
            SlotView  slotView1=(SlotView)((PomocniSlot) notification).getSlot().getSubscribers().get(0);
            SlotView  slotView2=(SlotView)((PomocniSlot) notification).getSlot().getSubscribers().get(1);
            SlotView  slotView3=(SlotView)((PomocniSlot) notification).getSlot().getSubscribers().get(2);
            listaSlotView.remove(slotView1);
            listaSlotView.remove(slotView2);
            listaSlotView.remove(slotView3);
            this.repaint();
        }
        else
        {
            this.repaint();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlajdView slajdView = (SlajdView) o;
        return br == slajdView.br && Objects.equals(slajd, slajdView.slajd);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
       String url = ((Presentation)slajd.getParent()).getUrlSlike();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(url));
        } catch (IOException e) {
        }
        g.drawImage(img,0,0,getWidth(),getHeight(),null);
        for (SlotView slotView:listaSlotView) {

            slotView.paint(g);
        }

    }

    public void addSlotView(SlotView slotView)
    {
        listaSlotView.add(slotView);
    }

    @Override
    public String toString() {
        return  slajd.toString();
    }

    public Slajd getSlajd() {
        return slajd;
    }

    public void setSlajd(Slajd slajd) {
        this.slajd = slajd;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
