package dswRudokApp.gui.view;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.Type;

import javax.swing.*;
import java.awt.*;

public class StateToolbar extends JToolBar {
    public StateToolbar()
    {
        super(HORIZONTAL);
        setMaximumSize(new Dimension(300,12));
        setFloatable(false);

    }
    public void setEditMode()
    {
        removeAll();
        add(MainFrame.getInstance().getActionManager().getSlideShowAction());
        add(MainFrame.getInstance().getActionManager().getChangeColorAction());
        add(new JSeparator(SwingConstants.VERTICAL));
        String[] choose={"Image","Text"};
        JComboBox jComboBox=new JComboBox(choose);
        jComboBox.setSelectedIndex(1);
        jComboBox.setMaximumSize(new Dimension(150,20));
        jComboBox.addActionListener(e->{
            int index=MainFrame.getInstance().getProjectView().getjTabbedPane().getSelectedIndex();
            Project ruNode=MainFrame.getInstance().getProjectView().getProject();
            Presentation presentation=(Presentation)(ruNode.getListaRuNodova().get(index));
            int type=jComboBox.getSelectedIndex();
            if(type==1)
                presentation.setType(Type.Text);
            else
                presentation.setType(Type.Image);


        });
        add(jComboBox);
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getChangeTicknessAction());
        add(MainFrame.getInstance().getActionManager().getChangeStrokeAction());
        add(MainFrame.getInstance().getActionManager().getAddSlotAction());
        add(MainFrame.getInstance().getActionManager().getRemoveSlotAction());
        add(MainFrame.getInstance().getActionManager().getMoveSlotAction());
        add(MainFrame.getInstance().getActionManager().getSelectSlotAction());
        add(MainFrame.getInstance().getActionManager().getEditSlotAction());


    }
    public void setSlideShowMode()
    {
        this.removeAll();
        add(MainFrame.getInstance().getActionManager().getExitSlideShowAction());

    }
}
