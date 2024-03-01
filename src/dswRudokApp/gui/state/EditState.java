package dswRudokApp.gui.state;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.EditShowView;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.SlideShowView;
import dswRudokApp.gui.view.tree.PresentationView;

import javax.swing.*;
import java.awt.*;

public class EditState implements State{

    @Override
    public void showContent() {
        int index=MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));


        //EditShowView editShowView=new EditShowView(presentation);
        PresentationView presentationView =(PresentationView) presentation.getSubscribers().get(0);
        presentationView.removeAll();
        presentationView.getStateToolbar().setEditMode();
        presentationView.dodajTulbar();
        presentationView.add(presentationView.getEditShowView());

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getContentPane());

    }
}
