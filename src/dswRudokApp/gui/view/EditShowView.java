package dswRudokApp.gui.view;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.SlajdView;

import javax.swing.*;
import java.awt.*;

public class EditShowView extends JPanel {
    private Presentation presentation;
    private JPanel jPanel;
    private JPanel jPanel1;

    public EditShowView(Presentation presentation) {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300,300));
        this.presentation=presentation;
        jPanel=new JPanel();
        jPanel1=new JPanel();
        paint();
    }

    public void paint()
    {
        this.removeAll();
        jPanel.removeAll();
        jPanel1.removeAll();
        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);

        JLabel jLabel=new JLabel(presentation.getNazivAutora());
        this.add(jLabel);

        for (RuNode s: presentation.getListaRuNodova()) {
            if(s instanceof Slajd)
            {

                SlajdView slajdView = (SlajdView) ((Slajd) s).getSubscribers().get(0);
                SlajdView slajdView1 = (SlajdView) ((Slajd) s).getSubscribers().get(1);
                jPanel.add(slajdView);
                jPanel.add(Box.createVerticalStrut(15));
                jPanel1.add(slajdView1);
                jPanel1.add(Box.createVerticalStrut(15));
            }
        }
        this.add(presentationView.getStateToolbar(),BorderLayout.NORTH);
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        JScrollPane jScrollPane=new JScrollPane(jPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(jScrollPane, BorderLayout.CENTER);

        jPanel1.setLayout(new BoxLayout(jPanel1,BoxLayout.Y_AXIS));
        JScrollPane jScrollPane1=new JScrollPane(jPanel1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(jScrollPane1,BorderLayout.WEST);
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
        paint();
    }

   public void dodajSlajd(SlajdView sv,SlajdView sv1)
   {
       jPanel.add(sv);
       jPanel.add(Box.createVerticalStrut(15));
       jPanel1.add(sv1);
       jPanel1.add(Box.createVerticalStrut(15));
       this.repaint();
   }
}
