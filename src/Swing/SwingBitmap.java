package Swing;

import Model.Bitmap;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SwingBitmap implements Bitmap {

    private final String path;

    public SwingBitmap(String path) {
        this.path = path;
    }

    @Override
    public BufferedImage load() {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException ex) {
            return null;
        }
    }

}
