package View.Persistence;

import Swing.SwingImage;
import java.io.File;

public class GalleryLoader {

    private final File[] listFiles;
    private SwingImage first;

    public GalleryLoader(File[] listFiles) {
        this.listFiles = listFiles;
    }

    public SwingImage load() {
        createGallery();
        return first;
    }

    private void createGallery() {
        if(listFiles == null){
            return;
        }
        if(listFiles.length == 0){
            return;
        }
        SwingImage prev;
        SwingImage current;
        first = prev = current = new SwingImage(listFiles[0].getAbsolutePath());
        
        for (int i = 1; i < listFiles.length; i++) {
            current = new SwingImage(listFiles[i].getAbsolutePath());
            current.setPrev(prev);
            prev.setNext(current);
            prev = current;
        }
        current.setNext(first);
        first.setPrev(current);
    }
}
