package imageviewer;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

    private Image image;
    private ButtonPanel buttonPanel;
    private PaintPanel paintPanel;

    public ImagePanel() {
        this.setLayout(new BorderLayout());
        createPaintPanel();
        createButtonPanel();
    }

    public void load(File directory) {
        image = new GalleryLoader(directory.listFiles(new ImageFilter())).load();
        if (paintPanel == null) {
            System.out.println("paintpanel is null");
        }
        paintPanel.setImage(image);
    }

    private void createPaintPanel() {
        paintPanel = new PaintPanel();
        this.add(paintPanel, CENTER);
    }

    private void createButtonPanel() {
        buttonPanel = new ButtonPanel(createCommands());
        this.add(buttonPanel, SOUTH);
    }

    private ActionListener[] createCommands() {
        return new ActionListener[]{
            new PrevImageCommand(paintPanel),
            new NextImageCommand(paintPanel)
        };
    }
}
