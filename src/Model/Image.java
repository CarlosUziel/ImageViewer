package Model;

import Swing.SwingImage;

public class Image implements SwingImage{
    private final String path;
    private Image prev;
    private Image next;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }  

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public void setPrev(Image prev) {
        this.prev = prev;
    }

    @Override
    public void setNext(Image next) {
        this.next = next;
    }

}
