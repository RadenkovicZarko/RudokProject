package dswRudokApp.gui.view;

import dswRudokApp.gui.controller.FileFilterRuDok;
import dswRudokApp.gui.controller.Utils;
import dswRudokApp.gui.controller.WorkspaceFileFilter;
import dswRudokApp.gui.model.Project;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ChooseWorkspaceOpening extends JDialog {

    public ChooseWorkspaceOpening(){
        this.setMinimumSize(new Dimension(250,200));
        this.setMaximumSize(new Dimension(250,200));
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension dimension=toolkit.getScreenSize();
        this.setLocation(new Point(dimension.width/2-100,dimension.height/2-100));
        this.setLayout(new BorderLayout());

        JButton jButton=new JButton("Ok");jButton.setMinimumSize(new Dimension(200,200));
        JButton jButton1=new JButton("Cancel");jButton1.setMinimumSize(new Dimension(200,200));
        JButton jButton2=new JButton("Choose");jButton2.setMinimumSize(new Dimension(200,200));
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.X_AXIS));
        jPanel.add(Box.createHorizontalStrut(15));
        jPanel.add(jButton);jPanel.add(Box.createHorizontalStrut(15));
        jPanel.add(jButton1);jPanel.add(Box.createHorizontalStrut(15));
        jPanel.add(jButton2);jPanel.add(Box.createHorizontalStrut(15));
        this.add(new JLabel("Da li zelite da se ucita prethodni kontent?"),BorderLayout.NORTH);
        this.add(jPanel,BorderLayout.CENTER);


        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileFilter(new WorkspaceFileFilter());
                if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    String adresa= jfc.getSelectedFile().toString();
                    Utils.pisiWorkspace(adresa);
                    dispose();
            }}
        });

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adresa= Utils.getLokacija();
                Utils.pisiWorkspace(adresa);
                dispose();
            }
        });
    }
}
