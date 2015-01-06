package imageviewer;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

    private Image image;
    private ButtonPanel buttonPanel;
    private BufferedImage bImage;

    public ImagePanel() {
        this.setLayout(new BorderLayout());
    }

    public void load(File directory) {
        System.out.println(directory.getAbsolutePath());
        image = new GalleryLoader(directory.listFiles(new ImageFilter())).load();
        if (image != null) {
            setImage(image);
        }
    }

    public void setImage(Image image) {
        this.image = image;
        try {
            bImage = ImageLoader.load(image.getPath());
            repaint();
        } catch (IOException ex) {
        }
    }

    public Image getImage() {
        return image;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int width = getImageWidth();
        int height = getImageHeight();
        g.drawImage(bImage, (getWidth()-width)/2, (getHeight()-height)/2, width, height, null);
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
            return (int)(getWidth()*aspectRatio);
        } else {
            return getHeight();
        }

    }
}
