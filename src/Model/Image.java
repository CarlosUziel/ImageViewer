package Model;

public interface Image {
    public Image getPrev();
    public Image getNext();
    
    public Bitmap getBitmap();
    public void setPrev(Image prev);
    public void setNext(Image next);
}
