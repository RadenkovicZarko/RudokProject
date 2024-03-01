package dswRudokApp.gui.controller;

import com.sun.tools.javac.Main;

import dswRudokApp.gui.view.InfoDialog;
import dswRudokApp.gui.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.security.spec.NamedParameterSpec;
import java.util.jar.JarEntry;

public class InfoAction extends AbstractRudokAction{

    public InfoAction()
    {
        putValue(SMALL_ICON,loadIcon("images/info5.png"));
        putValue(NAME,"Info");
        putValue(SHORT_DESCRIPTION,"Info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InfoDialog infoDialog=new InfoDialog();
        infoDialog.setVisible(true);

    }


}
