package Swing;

import Model.Image;

public interface SwingImage {
    public abstract Image getPrev();
    public abstract Image getNext();
    
    public abstract void setPrev(Image prev);
    public abstract void setNext(Image next);
}
