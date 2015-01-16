package Control;

import Swing.ImagePanel;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JOptionPane;

public class LoadImageCommand implements Command {

    private final ImagePanel imagePanel;

    public LoadImageCommand(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    @Override
    public void execute() {
        imagePanel.load(new File(getDirectory()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }

    private String getDirectory() {
        return JOptionPane.showInputDialog(imagePanel, "Introduce the directory containing the desired images:", "Selección de directorio", JOptionPane.QUESTION_MESSAGE);
    }

}
