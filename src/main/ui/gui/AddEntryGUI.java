package ui.gui;

import javax.swing.*;
import java.awt.*;

public class AddEntryGUI extends JFrame {
    private JFrame addFrame;
    private int frameWidth = 1000;
    private int frameHeight = 800;
    private JPanel optionPanel;

    public AddEntryGUI() {
        super("SimpleFly");
        setLayout(new BorderLayout());
        setSize(frameWidth,frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionPanel = new AddPanel();
        Container c = getContentPane();
        c.add(optionPanel, BorderLayout.WEST);
    }
}
