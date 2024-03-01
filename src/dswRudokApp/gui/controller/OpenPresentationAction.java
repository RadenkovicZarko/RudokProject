package dswRudokApp.gui.controller;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenPresentationAction extends AbstractRudokAction{

    public OpenPresentationAction() {
        putValue(SMALL_ICON, loadIcon("images/open.png"));
        putValue(NAME, "Open presentation");
        putValue(SHORT_DESCRIPTION, "Open presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilterPresentation());
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            ObjectInputStream os = null;
            try {
                os = new ObjectInputStream(new
                        FileInputStream(jfc.getSelectedFile()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Presentation p = null;
            try {
                assert os != null;
                p = (Presentation) os.readObject();
            } catch (ClassNotFoundException | IOException ez) {
                ez.printStackTrace();
            }
            MyTreeNode lastMTN = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
            if (lastMTN == null || !(lastMTN.getRuNode() instanceof Project)) return;
            Project project=(Project) lastMTN.getRuNode();
            project.addChild(p);
            p.setParent(project);
            Utils.citajPrezentaciju(p, lastMTN);
        }
    }
}
