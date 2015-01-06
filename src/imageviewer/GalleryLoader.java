package imageviewer;

import java.io.File;

class GalleryLoader {

    private final File[] listFiles;
    private Image first;

    public GalleryLoader(File[] listFiles) {
        this.listFiles = listFiles;
    }

    public Image load() {
        createGallery();
        return first;
    }

    private void createGallery() {
        Image prev, current;
        first = prev = current = new Image(listFiles[0].getAbsolutePath());
        
        for (int i = 1; i < listFiles.length; i++) {
            current = new Image(listFiles[i].getAbsolutePath());
            prev.setNext(current);
            prev = current;
        }
        current.setNext(first);
    }
}
