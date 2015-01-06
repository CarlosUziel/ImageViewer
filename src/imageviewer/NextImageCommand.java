package imageviewer;

import java.awt.event.ActionEvent;

public class NextImageCommand implements Command {

    private PaintPanel paintPanel;

    public NextImageCommand(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

    @Override
    public void execute() {
        paintPanel.setImage(paintPanel.getImage().getNext());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
