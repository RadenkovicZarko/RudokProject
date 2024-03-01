package dswRudokApp.gui.controller;

import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class SavePresentationAction extends AbstractRudokAction {

    public SavePresentationAction() {
        putValue(SMALL_ICON, loadIcon("images/save.png"));
        putValue(NAME, "Save presentation content");
        putValue(SHORT_DESCRIPTION, "Save presentation content");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        jfc.setFileFilter(new FileFilterPresentation());

        MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if (myTreeNode == null && !(myTreeNode.getRuNode() instanceof Presentation)) {
            ErrorFactory.getInstance().generateError(Errori.WRONG_COMPONENT_SELECTED);
            return;
        }

        Presentation presentation = (Presentation) myTreeNode.getRuNode();
        File fajl = null;
        if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            fajl = jfc.getSelectedFile();

        } else {
            return;
        }
        Utils.pisi(presentation,fajl);

    }
}
