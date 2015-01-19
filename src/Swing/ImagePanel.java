package Swing;

import View.Persistence.GalleryLoader;
import View.Persistence.ImageFilter;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private SwingImage image;
    private ButtonPanel buttonPanel;
    private BufferedImage bImage;

    public ImagePanel() {
        this.setLayout(new BorderLayout());
    }

    public void load(File directory) {
        if (directory == null) {
            return;
        }
        image = new GalleryLoader(directory.listFiles(new ImageFilter())).load();
        if (image != null) {
            setImage(image);
        }
    }

    public void setImage(SwingImage image) {
        this.image = image;
        bImage = image.getBitmap().load();
        repaint();
    }

    public SwingImage getImage() {
        return image;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getImageWidth();
        int height = getImageHeight();
        g.drawImage(bImage, (getWidth() - width) / 2, (getHeight() - height) / 2, width, height, null);
    }

    private int getImageWidth() {
        if (bImage == null) {
            return getWidth();
        }
        float aspectRatio = bImage.getHeight() / (float) bImage.getWidth();
        if (getWidth() * aspectRatio < getHeight()) {
            return getWidth();
        } else {
            return (int) (getHeight() / aspectRatio);
        }
    }

    private int getImageHeight() {
        if (bImage == null) {
            return getWidth();
        }
        float aspectRatio = bImage.getHeight() / (float) bImage.getWidth();
        if (getWidth() * aspectRatio < getHeight()) {
            return (int) (getWidth() * aspectRatio);
        } else {
            return getHeight();
        }

    }
}
