package ui.gui;

import javax.swing.*;
import java.awt.*;

public class AddPanel extends JPanel {
    private JButton addEntry;
    private JButton confirmAdd;
    private JButton returnToMain;
    private JLabel entryNumber;
    private JLabel month;
    private JLabel day;
    private JLabel airplaneModel;
    private JLabel airplaneName;
    private JLabel pic;
    private JLabel flightTime;
    private JLabel dayOrnight;
    private JLabel departure;
    private JLabel arrival;
    private JLabel note;

    JTextField entryNumberText;
    JTextField monthText;
    JTextField dayText;
    JTextField airplaneModelText;
    JTextField airplaneNameText;
    JTextField picText;
    JTextField flightTimeText;
    JTextField dayOrnightText;
    JTextField departureText;
    JTextField arrivalText;
    JTextField noteText;


    public AddPanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Main User Menu"));
        setUpButtons();
        setUpfieldLabels();
        setUpFields();
        displayLabels();
        displayTextFields();
    }

    private void setUpButtons() {
        addEntry = new JButton("Add an Entry");
        confirmAdd = new JButton("Confirm add this entry");
        returnToMain = new JButton("Return to main menu");
    }

    private void setUpfieldLabels() {
        entryNumber = new JLabel("Enter entry number");
        month = new JLabel("Enter month: ");
        day = new JLabel("Enter day: ");
        airplaneModel = new JLabel("Aircraft model: ");
        airplaneName = new JLabel("Name for the airplane: ");
        pic = new JLabel("Name of the Pilot: ");
        flightTime = new JLabel("Flight time: ");
        dayOrnight = new JLabel("D for day and N for night: ");
        departure = new JLabel("Departure airport:");
        arrival = new JLabel("Destination airport: ");
        note = new JLabel("Remark: ");
    }

    private void setUpFields() {
        entryNumberText = new JTextField(10);
        monthText = new JTextField(10);
        dayText = new JTextField(10);
        airplaneModelText = new JTextField(10);
        airplaneNameText = new JTextField(10);
        picText = new JTextField(10);
        flightTimeText = new JTextField(10);
        dayOrnightText = new JTextField(10);
        departureText = new JTextField(10);
        arrivalText = new JTextField(10);
        noteText = new JTextField(10);
    }

    private void displayLabels() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5,8,8,8);
        gc.anchor = GridBagConstraints.LINE_END;

        gc.gridx = 0;
        gc.gridy = 0;
        add(entryNumber, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(month, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(day, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        add(airplaneModel, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        add(airplaneName, gc);
        gc.gridx = 0;
        gc.gridy = 5;
        add(pic, gc);
        gc.gridx = 0;
        gc.gridy = 6;
        add(flightTime, gc);
        gc.gridx = 0;
        gc.gridy = 7;
        add(dayOrnight, gc);
        gc.gridx = 0;
        gc.gridy = 8;
        add(note, gc);
    }

    private void displayTextFields() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(5,5,5,5);
        gc.gridx = 1;
        gc.gridy = 0;
        add(entryNumberText, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        add(monthText, gc);
        gc.gridx = 1;
        gc.gridy = 2;
        add(dayText, gc);
        gc.gridx = 1;
        gc.gridy = 3;
        add(airplaneModelText, gc);
        gc.gridx = 1;
        gc.gridy = 4;
        add(airplaneNameText, gc);
        gc.gridx = 1;
        gc.gridy = 5;
        add(picText, gc);
        gc.gridx = 1;
        gc.gridy = 6;
        add(flightTimeText, gc);
        gc.gridx = 1;
        gc.gridy = 7;
        add(dayOrnightText, gc);
        gc.gridx = 1;
        gc.gridy = 8;
        add(noteText, gc);
        gc.gridx = 1;
        gc.gridy = 9;
        add(confirmAdd, gc);
        gc.gridx = 1;
        gc.gridy = 11;
        add(addEntry, gc);
        gc.gridx = 1;
        gc.gridy = 12;
        add(returnToMain, gc);
    }


}
