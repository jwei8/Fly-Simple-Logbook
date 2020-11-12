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
    private JFrame mainFrame;
    private int frameWidth = 500;
    private int frameHeight = 800;
    private JPanel optionPanel;
    private JButton addEntry;
    private JButton printEntry;
    private JButton loadEntry;
    private JButton quitLogbook;
    private JButton viewFleet;
    private JLabel planePicture;
    private JLabel title;
    private JScrollPane panel;

    //Constructor for JFrame
    public MainMenuGUI() {
        mainFrame = new JFrame("Fly Simple Logbook");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(frameWidth, frameHeight);

        optionPanel = new JPanel();
        optionPanel.setLayout(new GridBagLayout());
        optionPanel.setBackground(Color.darkGray);

        setUpButtons();
        displayButtons();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JScrollPane(optionPanel);
        mainFrame.add(panel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
        setUpListener();
    }

    //MODIFIES: This
    //EFFECT: setup JButtons for different operations, title and a welcome picture
    private void setUpButtons() {
        addEntry = new JButton("Add an entry");
        addEntry.setBackground(Color.white);
        addEntry.setPreferredSize(new Dimension(200, 40));

        printEntry = new JButton("View all logbook entry");
        printEntry.setPreferredSize(new Dimension(200, 40));
        printEntry.setBackground(Color.white);


        loadEntry = new JButton("Load entries from file");
        loadEntry.setPreferredSize(new Dimension(200, 40));
        loadEntry.setBackground(Color.white);

        viewFleet = new JButton("View aircraft picture");
        viewFleet.setPreferredSize(new Dimension(200, 40));
        viewFleet.setBackground(Color.white);

        quitLogbook = new JButton("Quit logbook");
        quitLogbook.setPreferredSize(new Dimension(200, 40));
        quitLogbook.setBackground(Color.white);

        title = new JLabel("<html><font color='white'> Welcome to Fly Simple Logbook!</font></html> ");
        title.setPreferredSize(new Dimension(200, 40));

        planePicture = new JLabel();
        planePicture.setIcon(new ImageIcon("./data/mainMenuPic.png"));
    }

    //MODIFIES: this
    //EFFECT: create a buttons for the list of operations we can perform
    //reference: https://www.youtube.com/watch?v=g2vDARb7gx8&t=230s
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
        optionPanel.add(viewFleet, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        optionPanel.add(quitLogbook, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        optionPanel.add(planePicture, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        optionPanel.add(title, gc);
    }

    //MODIFIES: this
    //EFFECT: setup action listener for each Jbutton
    private void setUpListener() {
        ActionHandle listener = new ActionHandle();

        addEntry.addActionListener(listener);
        printEntry.addActionListener(listener);
        viewFleet.addActionListener(listener);
        quitLogbook.addActionListener(listener);
    }

    //represents an ActionListener class
    //reference: https://stackoverflow.com/questions/6344269/jframe-actionlistener
    private class ActionHandle implements ActionListener {

        //REQUIRES: ActionEvent
        //MODIFIES: This
        //EFFECT: respond to the user's selection and create the next frame
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addEntry) {
                openAddEntry();
                playMusic("./data/clickButton.wav");

            } else if (e.getSource() == viewFleet) {
                playMusic("./data/clickButton.wav");
                new FleetGUI();
                mainFrame.dispose();

            } else if (e.getSource() == quitLogbook) {
                mainFrame.dispose();
                playMusic("./data/clickButton.wav");

            } else if (e.getSource() == printEntry) {
                viewEntry();
                playMusic("./data/viewEntry.wav");

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
    //reference: https://www.youtube.com/watch?v=3q4f6I5zi2w
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
