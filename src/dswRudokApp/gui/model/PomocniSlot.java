package dswRudokApp.gui.model;

public class PomocniSlot {
    private Slot slot;
    private String string;

    public PomocniSlot(Slot slot, String string) {
        this.slot = slot;
        this.string = string;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
