package ui.gui;

import exceptions.InvalidInputException;
import model.LogbookRecord;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//represents the MainMenu Jframe
public class MainMenuGUI extends JFrame {
    private static final String JSON_STORE = "./data/logbookRecord.json";

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
    private JsonReader jsonReader;
    private LogbookRecord record;

    //Constructor for JFrame
    public MainMenuGUI() {
        super("SimpleFly");
        mainFrame = new JFrame();
        setLayout(new GridBagLayout());
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpMenuPanel();
        add(optionPanel);
        setUpListener();
    }

    //Constructor for JPanel
    private void setUpMenuPanel() {
        optionPanel = new JPanel();
        optionPanel.setLayout(new GridBagLayout());
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        setUpButtons();
        displayButtons();
    }

    //MODIFIES: This
    //EFFECT: setup Jbuttons for ediffernt operations the program can do
    private void setUpButtons() {
        addEntry = new JButton("Add an Entry");
        saveEntry = new JButton("Save entry");
        printEntry = new JButton("View all logbook entries");
        loadEntry = new JButton("Load entries from file");
        filterEntry = new JButton("Filter entries");
        quitLogbook = new JButton("Quit logbook");
    }

    //MODIFIES: this
    //EFFECT: create a buttons for the list of operations we can perform
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

    //MODIFIES: this
    //EFFECT: setup action listener for each Jbutton

    private void setUpListener() {
        ActionHandle listener = new ActionHandle();

        addEntry.addActionListener(listener);
        printEntry.addActionListener(listener);
        saveEntry.addActionListener(listener);
        loadEntry.addActionListener(listener);
        quitLogbook.addActionListener(listener);
    }
    //represents an ActionListener class

    protected class ActionHandle implements ActionListener {

        //REQUIRES: ActionEvent
        //MODIFIES: This
        //EFFECT: respond to the user's selection and create the next frame
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addEntry) {
                openAddEntry();
            } else if (e.getSource() == loadEntry) {
                loadLogbookEntries();
                JOptionPane.showMessageDialog(mainFrame.getComponent(0), "Entries are loaded successfully");
            } else if (e.getSource() == quitLogbook) {
                dispose();
            } else if (e.getSource() == printEntry) {
                viewEntry();
            }
        }

        //EFFECT: load the Json file to retrieve existing entries
        private void loadLogbookEntries() {
            jsonReader = new JsonReader(JSON_STORE);

            try {
                record = jsonReader.read();
                System.out.println("Loaded " + record.getName() + " from " + JSON_STORE);
            } catch (IOException e) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }
        }

        //EFFECT: load a new JFrame to perform add entry
        private void openAddEntry() {
            AddEntryGUI addEntryGUI = new AddEntryGUI();
            addEntryGUI.setVisible(true);
            dispose();
        }

        //EFFECT: load a new Jframe to display all entry
        private void viewEntry() {
            new ViewEntryGUI();

        }
    }

}
