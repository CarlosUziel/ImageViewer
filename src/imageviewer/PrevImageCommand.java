package imageviewer;

import java.awt.event.ActionEvent;

public class PrevImageCommand implements Command {
    
    private ImagePanel imagePanel;

    public PrevImageCommand(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    @Override
    public void execute() {
        imagePanel.setImage(imagePanel.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
