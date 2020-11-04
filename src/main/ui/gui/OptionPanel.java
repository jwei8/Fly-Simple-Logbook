//package ui.gui;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowEvent;
//
//public class OptionPanel extends JPanel {
//
//    private JButton addEntry;
//    private JButton saveEntry;
//    private JButton printEntry;
//    private JButton loadEntry;
//    private JButton filterEntry;
//    private JButton quitLogbook;
//    private JPanel addPanel;
//    private JPanel optionPanel;
//
//    private void getAddPanel() {
//        addPanel = new AddPanel();
//    }
//
//    public OptionPanel() {
//        Dimension size = getPreferredSize();
//        size.width = 400;
//        setPreferredSize(size);
//        setBorder(BorderFactory.createTitledBorder("Main User Menu"));
//        setUpButtons();
//        displayButtons();
//        getAddPanel();
//        setUpListener();
//    }
//
//
//    private void setUpButtons() {
//        addEntry = new JButton("Add an Entry");
//        saveEntry = new JButton("Save entry");
//        printEntry = new JButton("Print all logbook entries");
//        loadEntry = new JButton("Load entries from file");
//        filterEntry = new JButton("Filter entries");
//        quitLogbook = new JButton("Quit logbook");
//    }
//
//    private void displayButtons() {
//        setLayout(new GridBagLayout());
//        GridBagConstraints gc = new GridBagConstraints();
//        gc.insets = new Insets(5, 8, 8, 8);
//        gc.gridx = 0;
//        gc.gridy = 0;
//        gc.fill = GridBagConstraints.HORIZONTAL;
//        add(addEntry, gc);
//        gc.gridx = 0;
//        gc.gridy = 1;
//        add(saveEntry, gc);
//        gc.gridx = 0;
//        gc.gridy = 2;
//        add(printEntry, gc);
//        gc.gridx = 0;
//        gc.gridy = 3;
//        add(loadEntry, gc);
//        gc.gridx = 0;
//        gc.gridy = 4;
//        add(filterEntry, gc);
//        gc.weighty = 20;
//        gc.gridx = 0;
//        gc.gridy = 5;
//        add(quitLogbook, gc);
//    }
//
//    private void setUpListener() {
//
//
//
//    }
//
//
//    }
//
////    private class ActionHandler extends JFrame implements ActionListener {
////
////        @Override
////        public void actionPerformed(ActionEvent e) {
////            if (e.getSource() == addEntry) {
////                launchAddEntryGUI();
////            }
////
////
////        }
////
////        public void launchAddEntryGUI() {
////            AddEntryGUI addFrame = new AddEntryGUI();
////            addFrame.setVisible(true);
////
////        }
//
//
//
//}
