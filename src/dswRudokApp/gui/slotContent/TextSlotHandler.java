package dswRudokApp.gui.slotContent;

import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.SlotView;

import javax.swing.*;
import java.awt.*;

public class TextSlotHandler extends SlotHandler{
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
        JLabel jLabel=new JLabel(slotView.getSlot().getContent());
        CellRendererPane cellRendererPane=new CellRendererPane();
        jLabel.setForeground(Color.BLACK);
        cellRendererPane.paintComponent(g,jLabel,slotView.getSlajdView(),slotView.getDx2()+1,slotView.getDy2(), slotView.getSlot().getWidth()*slotView.getDx2()/slotView.getSlot().getX(),slotView.getSlot().getHeight()*slotView.getDy2()/slotView.getSlot().getY());
    }

    @Override
    public void format() {

    }
}
