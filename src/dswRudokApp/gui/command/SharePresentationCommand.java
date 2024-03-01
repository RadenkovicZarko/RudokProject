package dswRudokApp.gui.command;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Workspace;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.tree.ProjectView;

import javax.swing.*;

public class SharePresentationCommand extends AbstractCommand{

    private MyTreeNode deteMTN;
    private MyTreeNode parentMTN;
    private MyTreeNode originalMTN;
    public SharePresentationCommand(MyTreeNode deteMTN, MyTreeNode parentMTN,MyTreeNode originalMTN) {
        this.deteMTN = deteMTN;
        this.parentMTN = parentMTN;
        this.originalMTN=originalMTN;
    }

    @Override
    public void doCommand() {
        Project odabraniProjekat=(Project) parentMTN.getRuNode(); // Projekat RuNode u koji se stavlja prez koja je serovana
        odabraniProjekat.dodajSerovan(deteMTN.getRuNode());
        parentMTN.add(deteMTN);
        deteMTN.setParent(parentMTN);// MTN projektu dodajem MTN prez
        ((Presentation)deteMTN.getRuNode()).getListaProjekata().add(odabraniProjekat); //Dodajem u prez projekat u koji je serovan
        if(deteMTN.getChildCount()!=originalMTN.getChildCount()) {
            for (RuNode slide : ((Presentation) deteMTN.getRuNode()).getListaRuNodova()) {
                deteMTN.add(new MyTreeNode(slide));
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
    }

    @Override
    public void undoCommand() {
        Presentation dete=(Presentation) deteMTN.getRuNode();
        Project parent=(Project)parentMTN.getRuNode();

        parentMTN.remove(deteMTN);
        dete.getListaProjekata().remove(parent);
        parent.izbrisiSerovan(dete);

        deteMTN.setParent(null);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());

    }
}
