package Swing;

import Model.Bitmap;
import Model.Image;

public class SwingImage implements Model.Image{
    private final String path;
    private SwingImage prev;
    private SwingImage next;
    private Bitmap bitmap;

    public SwingImage(String path) {
        this.path = path;
        this.bitmap = new SwingBitmap(path);
    }

    public String getPath() {
        return path;
    }  

    @Override
    public SwingImage getPrev() {
        return prev;
    }

    @Override
    public SwingImage getNext() {
        return next;
    }

    @Override
    public void setPrev(Image prev) {
        this.prev = (SwingImage) prev;
    }

    @Override
    public void setNext(Image next) {
        this.next = (SwingImage) next;
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

}
