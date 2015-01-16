package Control;

import Swing.DirectoryChooserDialog;
import Swing.ImagePanel;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadImageCommand implements Command {

    private final ImagePanel imagePanel;

    public LoadImageCommand(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    @Override
    public void execute() {
        imagePanel.load(getDirectory());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }

    private File getDirectory() {
        return new DirectoryChooserDialog().getDirectory();
    }

}
