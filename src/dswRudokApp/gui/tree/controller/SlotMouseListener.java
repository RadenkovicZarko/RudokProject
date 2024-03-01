package dswRudokApp.gui.tree.controller;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.SlajdView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SlotMouseListener extends MouseAdapter {
    private SlajdView slajdView;

    public SlotMouseListener(SlajdView slajdView) {
        this.slajdView = slajdView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mousePressed(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        presentationView.mouseP((SlajdView) e.getComponent(),e.getX(),e.getY());
        slajdView.setPoint(new Point(e.getX(),e.getY()));
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        Slajd slajd=(Slajd) ((SlajdView)e.getComponent()).getSlajd();

        for(Slot s:slajd.getListaSlotova())
        {
            s.setPomera(false);
        }


    }

}
