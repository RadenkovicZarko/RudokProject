package dswRudokApp.gui.view.tree;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.*;
import dswRudokApp.gui.observer.ISubscriber;
import dswRudokApp.gui.slotState.StateManagerSlot;
import dswRudokApp.gui.state.EditState;
import dswRudokApp.gui.state.SlideShowState;
import dswRudokApp.gui.state.StateManager;
import dswRudokApp.gui.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PresentationView extends JPanel implements ISubscriber {
    private Presentation presentation;
    private StateManager stateManager;
    private StateManagerSlot stateManagerSlot;
    private StateToolbar stateToolbar;
    private SlideShowView slideShowView;
    private EditShowView editShowView;



    public PresentationView(Presentation presentation)
    {
        this.stateManagerSlot=new StateManagerSlot();
        this.stateManager=new StateManager();
        this.presentation=presentation;
        this.presentation.addSubscriber(this);
        stateManager.setEditState();
        this.setLayout(new BorderLayout());
        stateToolbar=new StateToolbar();
        stateToolbar.setEditMode();
        slideShowView=new SlideShowView(this.presentation);
        editShowView=new EditShowView(this.presentation);
        this.add(editShowView,BorderLayout.CENTER);
    }

    @Override
    public void update(Object notification) {
        if( MainFrame.getInstance().getProjectView().getProject()==null)
            return;
        if(notification instanceof String && !(notification.equals("URL")))
        {
            Project ruNode=(Project) presentation.getParent();
            MainFrame.getInstance().getProjectView().getjTabbedPane().setTitleAt(ruNode.findIndexByChild(this.presentation),(String)notification);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getjPanel());
        }
        else if(notification instanceof Slajd)
        {
            editShowView.dodajSlajd((SlajdView)((Slajd) notification).getSubscribers().get(0),(SlajdView)((Slajd) notification).getSubscribers().get(1));
            slideShowView.dodajSlajd((SlajdView)((Slajd) notification).getSubscribers().get(2));
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getjPanel());
        }
         else if(notification instanceof Dimension)
        {
            removeAll();
            slideShowView.paint();
            editShowView.paint();
            if(stateManager.getCurr() instanceof EditState)
                this.add(editShowView);
            else
                this.add(slideShowView);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getjPanel());
        } else if(notification.equals("URL"))
        {
            repaint();
        }
    }


    public void dodajTulbar()
    {
        this.add(stateToolbar,BorderLayout.NORTH);
    }

    public void startEditState(){this.stateManager.setEditState();}
    public void startSlideShowState(){
        this.stateManager.setSlideShowState();
    }
    public void startSelectState(){this.stateManagerSlot.setSelectionState();}
    public void showContent()
    {
        this.stateManager.getCurr().showContent();
    }
    public void startMoveSlotState(){this.stateManagerSlot.setMoveState();}
    public void startAddState(){this.stateManagerSlot.setAddState();}
    public void startDeleteState(){this.stateManagerSlot.setDeleteState();}

    public void mouseP(SlajdView slajdView, int x, int y)
    {

        this.stateManagerSlot.getCurr().mousePressed(slajdView,x,y);

    }
    public void mouseD(SlajdView slajdView, int x, int y)
    {
        this.stateManagerSlot.getCurr().mouseDrag(slajdView,x,y);
    }
    public StateToolbar getStateToolbar() {
        return stateToolbar;
    }
    public void setStateToolbar(StateToolbar stateToolbar) {
        this.stateToolbar = stateToolbar;
    }
    public Presentation getPresentation() {
        return presentation;
    }
    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
    @Override
    public String toString() {
        return presentation.getName() +" ";
    }
    public SlideShowView getSlideShowView() {
        return slideShowView;
    }
    public void setSlideShowView(SlideShowView slideShowView) {this.slideShowView = slideShowView;}
    public EditShowView getEditShowView() {
        return editShowView;
    }
    public void setEditShowView(EditShowView editShowView) {
        this.editShowView = editShowView;
    }

    public StateManagerSlot getStateManagerSlot() {
        return stateManagerSlot;
    }

    public void setStateManagerSlot(StateManagerSlot stateManagerSlot) {
        this.stateManagerSlot = stateManagerSlot;
    }
}
