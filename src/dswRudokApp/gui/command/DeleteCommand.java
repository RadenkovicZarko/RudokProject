package dswRudokApp.gui.command;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.model.*;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteCommand extends AbstractCommand{
    MyTreeNode parent;
    MyTreeNode child;
    List<MyTreeNode> listaParenta=new ArrayList<>();
    List<Integer> listaIndexa=new ArrayList<>();
    List<MyTreeNode> listaNodova=new ArrayList<>();

    public DeleteCommand(MyTreeNode parent, MyTreeNode child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {

        ((RuNodeComposite)parent.getRuNode()).removeChild(child.getRuNode());
        if(parent.getRuNode() instanceof Project){
            MyTreeNode workspace = (MyTreeNode) parent.getParent();
            for(int i=0;i<workspace.getChildCount();i++){
                MyTreeNode project = (MyTreeNode) workspace.getChildAt(i);
                for(int j=0;j<project.getChildCount();j++){
                    if(((MyTreeNode)project.getChildAt(j)).getRuNode().equals(child.getRuNode())){
                        listaParenta.add(project);
                        listaNodova.add((MyTreeNode) project.getChildAt(j));
                        listaIndexa.add(project.getIndex(project.getChildAt(j)));
                        MyTreeNode child=(MyTreeNode) project.getChildAt(j);
                        project.remove(child);
                        child.setParent(null);
                    }
                }
            }
            for(Project p:((Presentation) child.getRuNode()).getListaProjekata()){
                p.izbrisiSerovan((Presentation) child.getRuNode());
            }
        }


        if(parent.getRuNode() instanceof Presentation){
            MyTreeNode workspace = (MyTreeNode) parent.getParent().getParent();
            for(int i=0;i<workspace.getChildCount();i++){
                MyTreeNode project = (MyTreeNode) workspace.getChildAt(i);
                for(int j=0;j<project.getChildCount();j++){
                    MyTreeNode presentation = (MyTreeNode) project.getChildAt(j);
                    for(int k=0;k<presentation.getChildCount();k++){
                        MyTreeNode slide = (MyTreeNode) presentation.getChildAt(k);
                        if(slide.getRuNode()==(child.getRuNode())){
                            listaParenta.add(presentation);
                            listaNodova.add(slide);
                            listaIndexa.add(k);
                            presentation.remove(k);
                            slide.setParent(null);
                        }
                    }
                }
            }
        }
    if(!(parent.getRuNode() instanceof Project) && !(parent.getRuNode() instanceof Presentation))
    {
        listaIndexa.add(parent.getIndex(child));
        parent.remove(child);
        child.setParent(null);
    }

        child.getRuNode().setParent(null);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        if(child.getRuNode().equals(MainFrame.getInstance().getProjectView().getProject()))
        {
            MainFrame.getInstance().getProjectView().removeAll();
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getProjectView());
        }
    }

    @Override
    public void undoCommand() {

        (child.getRuNode()).setParent(parent.getRuNode());
        ((RuNodeComposite)parent.getRuNode()).addChild(child.getRuNode());

        if (child.getRuNode() instanceof Presentation) {
            for (int i = 0; i < listaParenta.size(); i++) {
                listaParenta.get(i).insert(listaNodova.get(i), listaIndexa.get(i));
                listaNodova.get(i).setParent(listaParenta.get(i));
                ((Project) listaParenta.get(i).getRuNode()).addChild((Presentation) listaNodova.get(i).getRuNode());
            }
        }

        if(child.getRuNode() instanceof Slajd){
            for(int i=0;i<listaParenta.size();i++){
                listaParenta.get(i).insert(listaNodova.get(i),listaIndexa.get(i));
                listaNodova.get(i).setParent(listaParenta.get(i));
            }
        }

        if(!(child.getRuNode() instanceof Slajd) && !(child.getRuNode() instanceof Presentation))
        {
            parent.insert(child,listaIndexa.get(0));
            child.setParent(parent);
        }
        listaParenta.clear();
        listaNodova.clear();
        listaIndexa.clear();
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());

    }

}
