package dswRudokApp.gui.controller;

import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.model.Type;
import dswRudokApp.gui.slotState.SelectionState;
import dswRudokApp.gui.state.EditState;
import dswRudokApp.gui.view.EditMultimediaSlotDialog;
import dswRudokApp.gui.view.EditTextSlotDialog;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.SlotView;
import dswRudokApp.gui.view.tree.PresentationView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditSlotAction extends AbstractRudokAction{
    public EditSlotAction() {
        putValue(SMALL_ICON,loadIcon("images/write.png"));
        putValue(NAME,"Edit slot content");
        putValue(SHORT_DESCRIPTION,"Edit slot content");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int index= MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
        Project ruNode=MainFrame.getInstance().getProjectView().getProject();
        Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));
        PresentationView presentationView=(PresentationView) presentation.getSubscribers().get(0);
        SlotView slotView;

        if((presentationView.getStateManagerSlot().getCurr() instanceof SelectionState) && ((SelectionState) (presentationView.getStateManagerSlot().getCurr())).getSelektovaniSlot()==null)
            return;


        if(presentationView.getStateManagerSlot().getCurr() instanceof SelectionState) {
            slotView = ((SelectionState) (presentationView.getStateManagerSlot().getCurr())).getSelektovaniSlot();

            if(slotView.getSlot().getType()==Type.Text)
            {
                EditTextSlotDialog editTextSlotDialog=new EditTextSlotDialog(slotView);
                editTextSlotDialog.setVisible(true);
            }
            else
            {
                EditMultimediaSlotDialog editMultimediaSlotDialog=new EditMultimediaSlotDialog(slotView);
                editMultimediaSlotDialog.setVisible(true);
            }
        }
        else
        {
            ErrorFactory.getInstance().generateError(Errori.NO_PERMISSION_ERROR);

        }
    }
}
