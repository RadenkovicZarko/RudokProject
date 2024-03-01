package dswRudokApp.gui.error;

public class MyError {

    String tekst;

    public MyError(String str) {
        this.tekst=str;
    }


    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
