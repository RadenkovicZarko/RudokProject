package dswRudokApp.gui.tree;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.command.RenameCommand;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Slajd;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class WorkspaceTreeEditor extends DefaultTreeCellEditor implements ActionListener {
    private Object stavka=null;
    private JTextField edit=null;

    public WorkspaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        stavka=arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }


    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                return true;
            }
        return false;
    }


    public void actionPerformed(ActionEvent e){
        if (!(stavka instanceof MyTreeNode))
            return;
        if(e.getActionCommand().isBlank())
            return;
        MyTreeNode clicked = (MyTreeNode) stavka;

        MainFrame.getInstance().getCommandManager().addCommand(new RenameCommand(clicked,clicked.getRuNode().getName(),e.getActionCommand()));
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());

    }
}
