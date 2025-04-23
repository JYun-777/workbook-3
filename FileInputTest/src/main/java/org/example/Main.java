package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        try
        {
            //create a FileinputStream object

            FileInputStream fis = new FileInputStream("c:\\pluralsight\\poem.txt");
            //Scanner
            Scanner scanner = new Scanner(fis);
            String input;
            //read until there is no moreo data
            while(scanner.hasNextLine()){

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //display stack trace if there was an error
        e.printStackTrace;
    }
}