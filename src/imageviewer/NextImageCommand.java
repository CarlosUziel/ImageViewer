package imageviewer;

import java.awt.event.ActionEvent;

public class NextImageCommand implements Command {

    private ImagePanel imagePanel;

    public NextImageCommand(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    @Override
    public void execute() {
        imagePanel.setImage(imagePanel.getImage().getNext());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
