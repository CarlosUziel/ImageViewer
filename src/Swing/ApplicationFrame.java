package Swing;

import Control.LoadImageCommand;
import Control.NextImageCommand;
import Control.PrevImageCommand;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenuBar;

public class ApplicationFrame extends JFrame {

    private ImagePanel imagePanel;
    private ApplicationMenuBar applicationMenuBar;

    public ApplicationFrame() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.getContentPane().add(createImagePanel(), CENTER);
        this.getContentPane().add(createMenuBar(), NORTH);
        this.getContentPane().add(createButtonPanel(), SOUTH);
    }

    private ImagePanel createImagePanel() {
        this.imagePanel = new ImagePanel();
        return imagePanel;
    }

    private JMenuBar createMenuBar() {
        applicationMenuBar = new ApplicationMenuBar(createLoadImageCommand());
        return applicationMenuBar;
    }

    private ButtonPanel createButtonPanel() {
        ButtonPanel buttonPanel = new ButtonPanel(createButtonsCommands());
        return buttonPanel;
    }

    private ActionListener[] createButtonsCommands() {
        return new ActionListener[]{
            new PrevImageCommand(imagePanel),
            new NextImageCommand(imagePanel)
        };
    }

    private ActionListener[] createLoadImageCommand() {
        return new ActionListener[]{
            new LoadImageCommand(imagePanel)
        };
    }
}
