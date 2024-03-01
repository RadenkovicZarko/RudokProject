package dswRudokApp.gui.view;

import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.tree.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeAutorDialog extends JDialog {

    public ChangeAutorDialog(MyTreeNode myTreeNode) {
        this.setResizable(false);
        setBounds(100, 100, 296, 175);
        setTitle("Change Autor");
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        JLabel jLabel=new JLabel("Insert new name:");
        jLabel.setBounds(57,10,150,20);
        jLabel.setFont(new Font("Courier New", Font.ITALIC, 12));
        add(jLabel);
        JTextField name = new JTextField();
        name.setBounds(57, 36, 175, 20);
        add(name);

        JButton btnOK = new JButton("Submit");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(name.getText().isBlank()) {
                    ErrorFactory.getInstance().generateError(Errori.EMPTY_NAME);
                return;
                }
                Presentation presentation=(Presentation) myTreeNode.getRuNode();
                presentation.setNazivAutora(name.getText());
                dispose();
            }
        });
        btnOK.setBounds(60, 93, 78, 23);
        add(btnOK);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
        btnCancel.setBounds(145, 93, 74, 23);
        add(btnCancel);
    }
}
