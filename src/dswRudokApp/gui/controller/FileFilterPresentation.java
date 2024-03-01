package dswRudokApp.gui.controller;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FileFilterPresentation extends FileFilter {
    @Override
    public String getDescription() {
        return "GrafEditor Project Files (*.pgpf)";
    }

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".pgpf"));
    }
}
