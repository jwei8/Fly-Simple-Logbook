package ui.gui;

import model.LogbookRecord;
import persistence.JsonReader;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


//represents the MainMenu Jframe
public class MainMenuGUI {
    private static final String JSON_STORE = "./data/logbookRecord.json";

    private JFrame mainFrame;
    private int frameWidth = 500;
    private int frameHeight = 800;
    private JPanel optionPanel;
    private JButton addEntry;
    private JButton printEntry;
    private JButton loadEntry;
    private JButton quitLogbook;
    private JLabel planePicture;
    private JLabel title;
    private JsonReader jsonReader;
    private LogbookRecord record;
    private JScrollPane panel;

    //Constructor for JFrame
    public MainMenuGUI() {
        mainFrame = new JFrame("Fly Simple Logbook");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(frameWidth, frameHeight);

        optionPanel = new JPanel();
        optionPanel.setLayout(new GridBagLayout());
        setUpButtons();
        displayButtons();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JScrollPane(optionPanel);
        mainFrame.add(panel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
        setUpListener();
    }

    //MODIFIES: This
    //EFFECT: setup JButtons for different operations the program can do
    private void setUpButtons() {
        addEntry = new JButton("Add an Entry");
        addEntry.setPreferredSize(new Dimension(200, 40));

        printEntry = new JButton("View all logbook entries");
        printEntry.setPreferredSize(new Dimension(200, 40));

        loadEntry = new JButton("Load entries from file");
        loadEntry.setPreferredSize(new Dimension(200, 40));

        quitLogbook = new JButton("Quit logbook");
        quitLogbook.setPreferredSize(new Dimension(200, 40));

        planePicture = new JLabel();
        title = new JLabel("    Welcome to Fly Simple Logbook!");
        title.setPreferredSize(new Dimension(200, 40));

        planePicture.setIcon(new ImageIcon("./data/mainMenuPic.png"));
    }

    //MODIFIES: this
    //EFFECT: create a buttons for the list of operations we can perform
    private void displayButtons() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 8, 8, 8);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.CENTER;

        optionPanel.add(addEntry, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        optionPanel.add(printEntry, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        optionPanel.add(loadEntry, gc);


        gc.gridx = 0;
        gc.gridy = 5;
        optionPanel.add(quitLogbook, gc);
        gc.gridx = 0;
        gc.gridy = 6;

        optionPanel.add(title, gc);
        gc.gridx = 0;
        gc.gridy = 7;
        optionPanel.add(planePicture, gc);
    }

    //MODIFIES: this
    //EFFECT: setup action listener for each Jbutton

    private void setUpListener() {
        ActionHandle listener = new ActionHandle();

        addEntry.addActionListener(listener);
        printEntry.addActionListener(listener);
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
                playMusic("./data/clickButton.wav");

            } else if (e.getSource() == loadEntry) {
                playMusic("./data/clickButton.wav");
                loadLogbookEntries();
                JOptionPane.showMessageDialog(mainFrame.getComponent(0), "Entries are loaded successfully");

            } else if (e.getSource() == quitLogbook) {
                mainFrame.dispose();
                playMusic("./data/clickButton.wav");

            } else if (e.getSource() == printEntry) {
                viewEntry();
                playMusic("./data/viewEntry.wav");

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
            mainFrame.dispose();
        }

        //EFFECT: load a new Jframe to display all entry
        private void viewEntry() {
            new ViewEntryGUI();

        }
    }


    //REQUIRE: String
    //MODIFIES: this
    //EFFECT: create sound effect for the button clicked
    public static void playMusic(String filePath) {
        InputStream music;

        try {
            music = new FileInputStream(new File(filePath));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");

        }
    }

}
