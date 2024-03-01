package dswRudokApp.gui.view;

import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.error.Errori;
import dswRudokApp.gui.model.Slot;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTextSlotDialog extends JDialog {
    private SlotView slotView;
    private Slot slot;

    public EditTextSlotDialog(SlotView slotView) {
        this.slotView=slotView;
        this.slot=slotView.getSlot();
        this.setMaximumSize(new Dimension(200,200));
        this.setMinimumSize(new Dimension(200,200));
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension dimension=toolkit.getScreenSize();
        this.setLocation(new Point(dimension.width/2-100,dimension.height/2-100));
        this.setLayout(new BorderLayout());


        JTextPane jTextPane=new JTextPane();
        jTextPane.setContentType("text/html");
        jTextPane.setText(slotView.getSlotHandler().readContent(slot));
        JButton bold=new JButton("B");
        JButton italic=new JButton("I");
        JButton underLine=new JButton("U");

        bold.addActionListener(new StyledEditorKit.BoldAction());
        italic.addActionListener(new StyledEditorKit.ItalicAction());
        underLine.addActionListener(new StyledEditorKit.UnderlineAction());

        JPanel jPanel=new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.X_AXIS));
        this.add(jTextPane,BorderLayout.CENTER);
        JButton jButton=new JButton("Save");
        jPanel.add(bold);
        jPanel.add(italic);
        jPanel.add(underLine);
        jPanel.add(jButton);
        this.add(jPanel,BorderLayout.NORTH);

        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slotView.getSlotHandler().setContent(slot,jTextPane.getText());
                dispose();
            }
        });
    }
}
