package imageviewer;

public class Image {
    private Dimension dimension;
    private final String path;
    private Image prev;
    private Image next;

    public Image(String path) {
        this.path = path;
    }
    
    public Dimension getDimension() {
        return dimension;
    }

    public String getPath() {
        return path;
    }  

    public Image getPrev() {
        return prev;
    }

    public Image getNext() {
        return next;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public void setPrev(Image prev) {
        this.prev = prev;
    }

    public void setNext(Image next) {
        this.next = next;
    }

}
