package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.*;

public class SaveAction extends AbstractRudokAction{

    public SaveAction() {
        putValue(SMALL_ICON,loadIcon("images/save.png"));
        putValue(NAME,"Save project content");
        putValue(SHORT_DESCRIPTION,"Save project content");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        jfc.setFileFilter(new FileFilterRuDok());

        MyTreeNode myTreeNode= (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(myTreeNode==null || !(myTreeNode.getRuNode() instanceof Project))
        {
            ErrorFactory.getInstance().generateError(Errori.WRONG_COMPONENT_SELECTED);
            return;
        }

        Project project=(Project) myTreeNode.getRuNode();
        File projectFile=project.getProjectFile();
        if (!project.isChanged()){
            return;
        }

        if (project.getProjectFile()==null){
            if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
                projectFile=jfc.getSelectedFile();

            }else{
                return;
            }

        }
        Utils.pisi(project,projectFile);
    }
}
