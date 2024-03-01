package dswRudokApp;

import dswRudokApp.gui.error.ErrorFactory;
import dswRudokApp.gui.view.MainFrame;

public class MyApp {
    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
        ErrorFactory.getInstance().addSubscriber(mainFrame);

    }
}
