package dswRudokApp.gui.controller;

import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.tree.MyTreeNode;
import dswRudokApp.gui.view.ChangeBackgroundJFileChooser;
import dswRudokApp.gui.view.MainFrame;
import dswRudokApp.gui.view.ShareDialog;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ShareAction extends AbstractRudokAction{
    public ShareAction() {
        putValue(SMALL_ICON,loadIcon("images/share.png"));
        putValue(NAME,"Share presentation");
        putValue(SHORT_DESCRIPTION,"Share presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode myTreeNode = (MyTreeNode) MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
        if(myTreeNode==null)
        {
            ErrorFactory.getInstance().generateError(Errori.NOTHING_SELECTED_ERROR); return;}
        if ( !(myTreeNode.getRuNode() instanceof Presentation))
        {
            ErrorFactory.getInstance().generateError(Errori.WRONG_COMPONENT_SELECTED);
            return;
        }
        ShareDialog shareDialog=new ShareDialog(myTreeNode);
        shareDialog.setVisible(true);
    }
}
