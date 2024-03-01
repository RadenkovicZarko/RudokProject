package dswRudokApp.gui.view;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.SlajdView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlideShowView extends JPanel {

    private Presentation presentation;
    JPanel cards=new JPanel();
    public SlideShowView(Presentation presentation) {
        this.setLayout(new BorderLayout());
        this.presentation=presentation;
        paint();
    }

    public void paint()
    {
        removeAll();
        cards.removeAll();
        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        this.add(presentationView.getStateToolbar(),BorderLayout.NORTH);
        cards=new JPanel(new CardLayout());
        for (RuNode r:presentation.getListaRuNodova()) {
            Slajd s=(Slajd) r;
            cards.add((SlajdView)s.getSubscribers().get(2));
        }
        class ControlActionListenter implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                String cmd = e.getActionCommand();
                if (cmd.equals("NEXT")) {
                    cl.next(cards);
                } else if (cmd.equals("PREVIOUS")) {
                    cl.previous(cards);
                }
            }
        }
        ControlActionListenter cal = new ControlActionListenter();

        JButton btn2 = new JButton("Next");
        btn2.setActionCommand("NEXT");
        btn2.addActionListener(cal);

        JButton btn3 = new JButton("Previous");
        btn3.setActionCommand("PREVIOUS");
        btn3.addActionListener(cal);

        JPanel controlButtons = new JPanel();
        controlButtons.add(btn2);
        controlButtons.add(btn3);

        this.add(cards,BorderLayout.CENTER);
        this.add(controlButtons,BorderLayout.PAGE_END);

    }



    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;

        this.paint();
    }

    public void dodajSlajd(SlajdView sv)
    {
        cards.add(sv);
        this.repaint();
    }
}
