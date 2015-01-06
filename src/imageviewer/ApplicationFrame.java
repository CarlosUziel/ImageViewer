package imageviewer;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

class ApplicationFrame extends JFrame {

    private ImagePanel imagePanel;

    public ApplicationFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.getContentPane().add(createImagePanel(),SOUTH);
        this.getContentPane().add(createMenuPanel(), CENTER);
    }

    private ImagePanel createImagePanel() {
        this.imagePanel = new ImagePanel();
        return imagePanel;
    }

    private JPanel createMenuPanel() {
        MenuPanel menuPanel = new MenuPanel(imagePanel);
        return menuPanel;
    }

}
