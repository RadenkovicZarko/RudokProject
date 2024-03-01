package dswRudokApp.gui.view;

import dswRudokApp.gui.command.SharePresentationCommand;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Workspace;
import dswRudokApp.gui.tree.MyTreeNode;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ShareDialog extends JDialog {

    public ShareDialog(MyTreeNode myTreeNode) {
        MyTreeNode workspaceMTN=(MyTreeNode) myTreeNode.getParent().getParent();

        JComboBox jComboBox=new JComboBox();

        for (int i=0;i<workspaceMTN.getChildCount();i++) {
            if(!(workspaceMTN.getChildAt(i).equals(myTreeNode.getParent())))
            {
                jComboBox.addItem(workspaceMTN.getChildAt(i));
            }
        }


        this.setMinimumSize(new Dimension(250,200));
        this.setMaximumSize(new Dimension(250,200));
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension dimension=toolkit.getScreenSize();
        this.setLocation(new Point(dimension.width/2-100,dimension.height/2-100));
        this.setLayout(new BorderLayout());
        this.add(new Label("Odaberi projekat u kom ce se podeliti prezentacija"),BorderLayout.NORTH);
        this.add(jComboBox,BorderLayout.CENTER);
        JButton ok=new JButton("Ok");
        this.add(ok,BorderLayout.SOUTH);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyTreeNode odabraniProjekatMTN=(MyTreeNode) jComboBox.getSelectedItem();
                MyTreeNode novaPrezentacijMTN=new MyTreeNode(myTreeNode.getRuNode());
                myTreeNode.getRuNode().setName(myTreeNode.getName()+" - Shared");
                novaPrezentacijMTN.setName(myTreeNode.getName()+" - Shared");
                myTreeNode.setName(novaPrezentacijMTN.getName());
                MainFrame.getInstance().getCommandManager().addCommand(new SharePresentationCommand(novaPrezentacijMTN,odabraniProjekatMTN,myTreeNode));
                dispose();
            }
        });


    }
}
