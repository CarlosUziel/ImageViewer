package imageviewer;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {

    private Image image;
    private BufferedImage bImage;
    private JLabel imageLabel;

    public PaintPanel() {
        imageLabel = new JLabel();
        this.add(imageLabel);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        try {
            bImage = ImageLoader.load(image.getPath());
            image.setDimension(new Dimension(bImage.getHeight(), bImage.getWidth()));
        } catch (IOException ex) {
        }
        setPicture();
        createImageLabelComponetListener();
    }

    private void setPicture() {
        imageLabel = new JLabel(new ImageIcon(bImage));
    }

    private void createImageLabelComponetListener() {
        imageLabel.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                revalidate();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
    }
}
