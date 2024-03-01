package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;
import dswRudokApp.gui.command.AddCommand;
import dswRudokApp.gui.model.*;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.tree.controller.SlotMouseListener;
import dswRudokApp.gui.tree.controller.SlotMouseMotionListener;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.SlotView;
import dswRudokApp.gui.view.tree.PresentationView;
import dswRudokApp.gui.view.tree.SlajdView;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class Utils {

    private static String lokacija="workspace.txt";

    private Utils() {
    }

    public static void citaj(Project p) {
        MyTreeNode projectMTN = new MyTreeNode(p);
        MyTreeNode workspaceMTN = (MyTreeNode) MainFrame.getInstance().getMyTree().getModel().getRoot();

        workspaceMTN.add(projectMTN);
        projectMTN.setParent(workspaceMTN);
        p.setParent(workspaceMTN.getRuNode());
        ((Workspace) workspaceMTN.getRuNode()).addChild(p);
        p.addSubscriber(MainFrame.getInstance().getProjectView());
        for (RuNode ruNode : ((Project) projectMTN.getRuNode()).getListaRuNodova()) {
            Presentation presentation = (Presentation) ruNode;
            Utils.citajPrezentaciju(presentation,projectMTN);
            }
            MainFrame.getInstance().getCommandManager().addCommand(new AddCommand(workspaceMTN, projectMTN));
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
        }


    public static void citajPrezentaciju(Presentation presentation, MyTreeNode projectMTN)
    {
        Project p=(Project) projectMTN.getRuNode();
        MyTreeNode presentationMTN = new MyTreeNode(presentation);
        presentation.setParent(p);

        projectMTN.add(presentationMTN);
        presentationMTN.setParent(projectMTN);
        for(RuNode slajdRN : presentation.getListaRuNodova())
        {
            MyTreeNode slajdMTN=new MyTreeNode(slajdRN);
            presentationMTN.add(slajdMTN);
            slajdRN.setParent(presentation);
            slajdMTN.setParent(presentationMTN);

            SlajdView slajdView1=new SlajdView((Slajd) slajdRN);
            SlajdView slajdView2=new SlajdView((Slajd) slajdRN,100,75);
            SlajdView slajdView3=new SlajdView((Slajd) slajdRN);

            slajdView1.addMouseListener(new SlotMouseListener(slajdView1));
            slajdView1.addMouseMotionListener(new SlotMouseMotionListener(slajdView1));

            for(Slot s: ((Slajd) slajdRN).getListaSlotova())
            {
                SlotView slotView1=new SlotView(s);
                SlotView slotView2=new SlotView(s);
                SlotView slotView3=new SlotView(s);

                slotView1.setSlajdView(slajdView1);
                slotView2.setSlajdView(slajdView2);
                slotView3.setSlajdView(slajdView3);

                slajdView1.addSlotView(slotView1);
                slajdView2.addSlotView(slotView2);
                slajdView3.addSlotView(slotView3);
            }
        }
        PresentationView presentationView = new PresentationView(presentation);
    }

    public static void pisi(RuNode ruNode,File file)
    {

        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(ruNode);
            if(ruNode instanceof Project) {
                Project project=(Project)ruNode;
                project.setProjectFile(file);
                project.setChanged(false);
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void pisiWorkspace(String adresa)
    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(adresa));
            String line = reader.readLine();
            while (line != null) {
                if(!line.contains(".gpf"))return;

                ObjectInputStream os = null;
                try {
                    os = new ObjectInputStream(new
                            FileInputStream(line));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                Project p = null;
                try {
                    assert os != null;
                    p = (Project) os.readObject();
                } catch (ClassNotFoundException | IOException ez) {
                    ez.printStackTrace();
                }

                Utils.citaj(p);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public static String getLokacija() {
        return lokacija;
    }

    public static void setLokacija(String lokacija) {
        Utils.lokacija = lokacija;
    }
}
