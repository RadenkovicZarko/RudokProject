package dswRudokApp.gui.slotContent;

import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.ImagePanel;
import dswRudokApp.gui.view.SlotView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MultimediaSlotHandler extends SlotHandler{
    @Override
    public String readContent(Slot slot) {
        return slot.getContent();
    }

    @Override
    public void setContent(Slot slot,String content) {
        slot.setContent(content);
    }

    @Override
    public void paint(SlotView slotView, Graphics2D g) {
        String url = slotView.getSlotHandler().readContent(slotView.getSlot());
        if(url!=null) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(url));
            } catch (IOException e) {
            }
            g.drawImage(img, slotView.getDx2(), slotView.getDy2(), slotView.getSlot().getWidth()*slotView.getDx2()/slotView.getSlot().getX()+1, slotView.getSlot().getHeight()* slotView.getDy2()/slotView.getSlot().getY()+1, null);
        }

    }

    @Override
    public void format() {

    }
}
