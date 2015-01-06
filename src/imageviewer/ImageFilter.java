package imageviewer;

import java.io.File;
import java.io.FilenameFilter;

class ImageFilter implements FilenameFilter {
    String[] acceptedExtensions = {".jpg", ".png", ".bmp", ".jpeg", ".gif"};

    @Override
    public boolean accept(File dir, String name) {
        for (int i = 0; i < acceptedExtensions.length; i++) {
            if (name.toLowerCase().endsWith(acceptedExtensions[i])) {
                return true;
            }
        }
        return false;
    }

}
