package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new FlySimpleLogbook();
        } catch (FileNotFoundException e) {
            System.out.println("unable to run application: file not found");
        }
    }
}
