package imageviewer;

import java.awt.event.ActionEvent;

public class PrevImageCommand implements Command {
    
    private PaintPanel paintPanel;

    public PrevImageCommand(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    @Override
    public void execute() {
        paintPanel.setImage(paintPanel.getImage().getPrev());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
