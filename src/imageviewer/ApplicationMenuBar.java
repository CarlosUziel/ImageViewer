package imageviewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

class ApplicationMenuBar extends JMenuBar {

    private final ImagePanel imagePanel;

    public ApplicationMenuBar(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
        createComponents();
    }

    private void createComponents() {
        this.add(createFileMenu());
    }

    private JMenu createFileMenu() {
        JMenu jMenu = new JMenu("File");
        createMenuItem(jMenu);
        return jMenu;
    }

    private void createMenuItem(JMenu jMenu) {
        jMenu.add(createOpenItem());
    }

    private JMenuItem createOpenItem() {
        JMenuItem openJMenuItem = new JMenuItem();
        openJMenuItem.setText("Open");
        openJMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                imagePanel.load(new File(getDirectory()));
            }

            private String getDirectory() {
                return JOptionPane.showInputDialog(null);
            }
        });
        return openJMenuItem;
    }

}
