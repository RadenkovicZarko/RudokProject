package dswRudokApp.gui.slotContent;

import dswRudokApp.gui.model.Slot;
import dswRudokApp.gui.view.SlotView;

import java.awt.*;

public abstract class SlotHandler {
    public abstract String readContent(Slot slot);
    public abstract void setContent(Slot slot, String content);
    public abstract void paint(SlotView slotView, Graphics2D g);
    public abstract void format();
}
