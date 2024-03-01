package dswRudokApp.gui.view;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.tree.MyTreeNode;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBackgroundJFileChooser extends JFileChooser {

    public ChangeBackgroundJFileChooser() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif", "png");
        this.setFileFilter(filter);
        MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();

            int returnVal = this.showOpenDialog(MainFrame.getInstance());
            if (returnVal == JFileChooser.APPROVE_OPTION) {


                Presentation presentation = (Presentation) myTreeNode.getRuNode();
                presentation.setUrlSlike(this.getSelectedFile().getAbsolutePath());
            }

    }
}
