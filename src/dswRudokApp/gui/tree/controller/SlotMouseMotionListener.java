package dswRudokApp.gui.tree.controller;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.SlotView;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.SlajdView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class SlotMouseMotionListener extends MouseAdapter {
    private SlajdView slajdView;

    public SlotMouseMotionListener(SlajdView slajdView) {
        this.slajdView = slajdView;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));
        slajdView=(SlajdView) e.getComponent();

        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        presentationView.mouseD((SlajdView) e.getComponent(),e.getX(),e.getY());

    }

}
