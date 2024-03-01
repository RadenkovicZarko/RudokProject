package dswRudokApp.gui.model;

public class PomocnaPrezentacija {
    private Presentation presentation;
    private String str;

    public PomocnaPrezentacija(Presentation presentation, String str) {
        this.presentation = presentation;
        this.str = str;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
