package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainMenuGUI extends JFrame {
    private JFrame mainFrame;
    private int frameWidth = 400;
    private int frameHeight = 800;
    private JPanel optionPanel;
    private JButton addEntry;
    private JButton saveEntry;
    private JButton printEntry;
    private JButton loadEntry;
    private JButton filterEntry;
    private JButton quitLogbook;
    private JPanel addPanel;


    public MainMenuGUI() {
        super("SimpleFly");
        setLayout(new GridBagLayout());
        setSize(frameWidth,frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpMenuPanel();
        add(optionPanel);
    }

    private void setUpMenuPanel() {
        optionPanel = new JPanel();
        optionPanel.setLayout(new GridBagLayout());
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        setUpButtons();
        displayButtons();
    }


    private void setUpButtons() {
        addEntry = new JButton("Add an Entry");
        saveEntry = new JButton("Save entry");
        printEntry = new JButton("Print all logbook entries");
        loadEntry = new JButton("Load entries from file");
        filterEntry = new JButton("Filter entries");
        quitLogbook = new JButton("Quit logbook");
    }

    private void displayButtons() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 8, 8, 8);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(addEntry, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        add(saveEntry, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        add(printEntry, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        add(loadEntry, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        add(filterEntry, gc);
        gc.weighty = 20;
        gc.gridx = 0;
        gc.gridy = 5;
        add(quitLogbook, gc);
    }

}
