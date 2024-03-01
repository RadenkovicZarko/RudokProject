package dswRudokApp.gui.view;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    public MenuBar()
    {
        JMenu fileMenu=new JMenu("File");
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteAction());
        JMenu helpMenu=new JMenu("Help");
        helpMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());

        JMenu editMenu=new JMenu("Edit");
        editMenu.add(MainFrame.getInstance().getActionManager().getChangeAutoraAction());
        editMenu.add(MainFrame.getInstance().getActionManager().getChangeBackgroundImageAction());

        add(fileMenu);
        add(editMenu);
        add(helpMenu);
    }
}
