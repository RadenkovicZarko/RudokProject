package dswRudokApp.gui.controller;

import dswRudokApp.gui.model.*;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.tree.controller.SlotMouseListener;
import dswRudokApp.gui.tree.controller.SlotMouseMotionListener;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.SlotView;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.SlajdView;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.*;

public class OpenAction extends AbstractRudokAction {

    public OpenAction() {
        putValue(SMALL_ICON, loadIcon("images/open.png"));
        putValue(NAME, "Open content");
        putValue(SHORT_DESCRIPTION, "Open content");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilterRuDok());
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {

            ObjectInputStream os = null;
            try {
                os = new ObjectInputStream(new
                        FileInputStream(jfc.getSelectedFile()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Project p = null;
            try {
                assert os != null;
                p = (Project) os.readObject();
            } catch (ClassNotFoundException | IOException ez) {
                ez.printStackTrace();
            }
            Utils.citaj(p);

        }
    }
}
