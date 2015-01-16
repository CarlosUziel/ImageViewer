package Swing;

import Model.Image;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

    private Image image;
    private int index = 0;
    private final ActionListener[] commands;

    public ButtonPanel(ActionListener[] commands) {
        this.commands = commands;
        createComponents();
    }

    private void createComponents() {
        this.add(createButton("<"));
        this.add(createButton(">"));
    }

    private JButton createButton(String direction) {
        JButton button = new JButton(direction);
        button.addActionListener(commands[index++]);
        return button;
    }
}
