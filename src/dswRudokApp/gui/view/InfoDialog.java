package dswRudokApp.gui.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class InfoDialog extends JDialog{
    public InfoDialog() {
        JLabel lbl=new JLabel("Zarko Radenkovic 5/20 RN");

        URL url=this.getClass().getResource("images/ja.jpg");
        if(url==null)
        {
            System.err.print("Greska");
            return;
        }

        ImageIcon mojaSlika=new ImageIcon(url);
        JLabel jLabel=new JLabel("Žarko Radenković 5/20 RN");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(new JLabel(mojaSlika), BorderLayout.CENTER);
        this.add(jLabel,BorderLayout.NORTH);
        this.setSize(600,600);
        this.setLocationRelativeTo(MainFrame.getInstance());
        this.setVisible(true);
    }
}
