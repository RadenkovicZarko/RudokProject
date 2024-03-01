package dswRudokApp.gui.view;

import dswRudokApp.gui.model.Presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {
    private String content;
    public ImagePanel(String string) {
        content=string;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String url = content;
        if(url!=null) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(url));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
