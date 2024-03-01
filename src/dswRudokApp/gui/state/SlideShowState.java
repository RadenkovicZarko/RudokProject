package dswRudokApp.gui.state;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.SlideShowView;
import dswRudokApp.gui.view.tree.PresentationView;

import javax.swing.*;
import java.awt.*;

public class SlideShowState implements State{

    @Override
    public void showContent() {
        //TRAZIM PREZENTACIJU KOJA JE U FOKUSU
        int index=MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));

        //BRISEM SVE SA DESNOG DELA I DODAJEM TULBAR I SlideShowView
        //SlideShowView slideShowView=new SlideShowView(presentation);
        PresentationView presentationView =(PresentationView) presentation.getSubscribers().get(0);
        presentationView.removeAll();
        presentationView.getStateToolbar().setSlideShowMode();
        presentationView.dodajTulbar();
        presentationView.add(presentationView.getSlideShowView());
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getContentPane());
    }
}
