package Swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    private final ImagePanel imagePanel;
    private JFileChooser jFileChooser;

    public MenuPanel(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
        this.setLayout(new FlowLayout());
        createComponents();
    }

    private void createComponents() {
        this.add(createJFileChooser());
        this.add(createRefreshButton());
    }

    private JFileChooser createJFileChooser() {
        this.jFileChooser = new JFileChooser();
        this.jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        this.jFileChooser.addActionListener((ActionEvent e) -> {
            imagePanel.load(this.jFileChooser.getSelectedFile());
        });
        return this.jFileChooser;
    }

    private JButton createRefreshButton() {
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener((ActionEvent e) -> {
            imagePanel.load(this.jFileChooser.getSelectedFile());
        });
        return refreshButton;
    }
}
