package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Project;
import dswRudokApp.gui.model.RuNode;
import dswRudokApp.gui.model.Workspace;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;

public class SaveWorkspaceAction extends AbstractRudokAction{
    public SaveWorkspaceAction() {
        putValue(SMALL_ICON,loadIcon("images/save.png"));
        putValue(NAME,"Save workspace content");
        putValue(SHORT_DESCRIPTION,"Save workspace content");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new WorkspaceFileFilter());
        jfc.showOpenDialog(MainFrame.getInstance());

        MyTreeNode myTreeNode= (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(myTreeNode==null || !(myTreeNode.getRuNode() instanceof Workspace))
        {
            ErrorFactory.getInstance().generateError(Errori.WRONG_COMPONENT_SELECTED);
            return;
        }
        Workspace workspace=(Workspace) myTreeNode.getRuNode();
        File fajl=new File("C:\\Users\\mega\\Radna površina");
        if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
            fajl=jfc.getSelectedFile();
        }
        try {
            fajl.createNewFile();
            FileWriter fileWriter=new FileWriter(fajl);
            for (RuNode ruNode:workspace.getListaRuNodova())
            {
                Project project=(Project) ruNode;
                if(project.getProjectFile()==null) {
                    File file=new File(fajl.getPath()+project.getName()+".gpf");
                    Utils.pisi(project,file);
                }
                Utils.pisi(project,project.getProjectFile());
                fileWriter.append(project.getProjectFile().getPath());
                fileWriter.append("\n");
            }
            fileWriter.close();
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
    }
}
