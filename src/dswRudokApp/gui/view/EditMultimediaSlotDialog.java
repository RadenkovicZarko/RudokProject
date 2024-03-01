package dswRudokApp.gui.view;

import dswRudokApp.gui.model.Presentation;
import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.tree.MyTreeNode;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class EditMultimediaSlotDialog extends JDialog {
    private SlotView slotView;
    private Slot slot;
    private String content;
    private ImagePanel imagePanel;


    public EditMultimediaSlotDialog(SlotView slotView) {
        this.slotView=slotView;
        this.slot=slotView.getSlot();
        this.setMaximumSize(new Dimension(200,200));
        this.setMinimumSize(new Dimension(200,200));
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension dimension=toolkit.getScreenSize();
        this.setLocation(new Point(dimension.width/2-100,dimension.height/2-100));
        imagePanel=new ImagePanel(slotView.getSlotHandler().readContent(slotView.getSlot()));

        this.setLayout(new BorderLayout());
        this.add(imagePanel,BorderLayout.CENTER);
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.X_AXIS));
        JButton jButton=new JButton("Save");
        jPanel.add(jButton);
        JButton jButton1=new JButton("Open");
        jPanel.add(jButton1);
        this.add(jPanel,BorderLayout.NORTH);


        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser=new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif", "png");
                jFileChooser.setFileFilter(filter);
                int returnVal = jFileChooser.showOpenDialog(MainFrame.getInstance());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    content =jFileChooser.getSelectedFile().getPath();
                    imagePanel.setContent(content);
                    imagePanel.repaint();
                }
            }
        });


        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                slotView.getSlotHandler().setContent(slot,content);
                dispose();
            }
        });

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
