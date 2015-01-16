package Swing;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class DirectoryChooserDialog extends JDialog{

    private JFileChooser directoryChooser;
    private File directory;
    
    public DirectoryChooserDialog() {
        createComponents();
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setSize(600, 400);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createDirectoryChooser());
    }

    private JFileChooser createDirectoryChooser() {
        this.directoryChooser = new JFileChooser();
        this.directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.directoryChooser.addActionListener((ActionEvent e) -> {
            this.directory = directoryChooser.getSelectedFile();
            DirectoryChooserDialog.this.dispose();
        });
        return directoryChooser;
        
    }

    public File getDirectory() {
        return directory;
    }

}
