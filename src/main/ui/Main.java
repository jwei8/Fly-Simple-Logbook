package ui;

import ui.gui.MainMenuGUI;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MainMenuGUI loginScreen = new MainMenuGUI();
        loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginScreen.setVisible(true);
    }


//        try {
//            new FlySimpleLogbook();
//        } catch (FileNotFoundException e) {
//            System.out.println("unable to run application: file not found");
//        }
//    }
}

