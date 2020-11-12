package ui.gui;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

//Represents the aircraft picture frame
public class FleetGUI {

    private JFrame aircraftProfile;
    private JPanel selectionPage;
    private JLabel profile1;
    private JLabel profile2;
    private JLabel profile3;
    private JLabel title;
    private JButton aircraft1;
    private JButton aircraft2;
    private JButton aircraft3;
    private JButton returnToMain;
    private int frameWidth = 500;
    private int frameHeight = 800;


    //constructor to create the GUI with its components
    public FleetGUI() {

        aircraftProfile = new JFrame("Aircraft pictures");
        selectionPage = new JPanel();
        selectionPage.setLayout(new GridBagLayout());
        selectionPage.setBackground(Color.darkGray);
        aircraftProfile.setLayout(new BorderLayout());
        createOption();
        loadPicture();
        setUpOption();
        setUpListener();
        aircraftProfile.setSize(frameWidth, frameHeight);
        aircraftProfile.setLocationRelativeTo(null);

        aircraftProfile.add(selectionPage, BorderLayout.CENTER);

        aircraftProfile.pack();

        aircraftProfile.setVisible(true);
    }


    //MODIFIES: this
    //EFFECT: construct each JLabel and JButtons for the panel
    private void createOption() {
        title = new JLabel("<html><font color='white'> Please select aircraft call sign!</font></html> ");
        title.setPreferredSize(new Dimension(200, 40));

        aircraft1 = new JButton("C-GXWS");
        aircraft1.setPreferredSize(new Dimension(200, 40));


        aircraft2 = new JButton("C-FVYG");
        aircraft2.setPreferredSize(new Dimension(200, 40));

        aircraft3 = new JButton("C-GQGR");
        aircraft3.setPreferredSize(new Dimension(200, 40));

        returnToMain = new JButton("Return to Main Menu");
        returnToMain.setPreferredSize(new Dimension(200, 40));


    }


    //MODIFIES: this
    //EFFECT: position the JButton and JLabel on the GridbagLayout panel
    //reference: https://www.youtube.com/watch?v=g2vDARb7gx8&t=230s
    private void setUpOption() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 8, 8, 8);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.CENTER;
        selectionPage.add(title, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        selectionPage.add(aircraft1, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        selectionPage.add(aircraft2, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        selectionPage.add(aircraft3, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        selectionPage.add(returnToMain, gc);

    }


    //MODIFIES: this
    //EFFECT: load picture to a JLabel to be displayed in a pop up window
    private void loadPicture() {
        profile1 = new JLabel();
        profile1.setIcon(new ImageIcon("./data/GXWS.jpg"));

        profile2 = new JLabel();
        profile2.setIcon(new ImageIcon("./data/FVYG.jpg"));

        profile3 = new JLabel();
        profile3.setIcon(new ImageIcon("./data/GQGR.jpg"));
    }

    //MODIFIES: this
    //EFFECT: setup action listener for each Jbutton
    //reference: https://stackoverflow.com/questions/6344269/jframe-actionlistener
    private void setUpListener() {
        FleetGUI.ActionHandle listener = new FleetGUI.ActionHandle();

        aircraft1.addActionListener(listener);
        aircraft2.addActionListener(listener);
        aircraft3.addActionListener(listener);
        returnToMain.addActionListener(listener);
    }

    //represents an ActionListener class
    private class ActionHandle implements ActionListener {

        //REQUIRES: ActionEvent
        //MODIFIES: This
        //EFFECT: respond to the user's selection and create the next frame
        //reference to display a pop up with picture:
        // https://stackoverflow.com/questions/15258467/java-how-can-i-popup-a-dialog-box-as-only-an-image

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == aircraft1) {
                playMusic("./data/clickButton.wav");
                JOptionPane.showMessageDialog(null, profile1, "Picture of GXWS",
                        JOptionPane.PLAIN_MESSAGE, null);


            } else if (e.getSource() == aircraft2) {
                playMusic("./data/clickButton.wav");
                JOptionPane.showMessageDialog(null, profile2, "Picture of FVYG",
                        JOptionPane.PLAIN_MESSAGE, null);

            } else if (e.getSource() == aircraft3) {
                playMusic("./data/clickButton.wav");
                JOptionPane.showMessageDialog(null, profile3, "Picture of GQGR",
                        JOptionPane.PLAIN_MESSAGE, null);

            } else if (e.getSource() == returnToMain) {
                playMusic("./data/viewEntry.wav");
                new MainMenuGUI();
                aircraftProfile.dispose();

            }
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
