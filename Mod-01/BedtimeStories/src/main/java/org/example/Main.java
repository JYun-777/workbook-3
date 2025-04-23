package org.example;

import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("Choose a bedtime story:\n   goldilocks.txt\n   hansel_and_gretel.txt\n   mary_had_a_little_lamb.txt");
            System.out.print(">>");
            String fileName = read.nextLine();
            try {
                FileInputStream fis = new FileInputStream(fileName);

                Scanner bookReader = new Scanner(fis);

                String input;
                //read Story until end of data
                while (bookReader.hasNextLine()) {
                    input = bookReader.nextLine();
                    System.out.println(input);
                }
                //close scanner
                bookReader.close();

            } catch (IOException e) {
                System.out.println("Can't find that text file. Please enter the file name.");
            }

            System.out.println("Would you like to hear another story? Enter (Y)es or (N)o.");
            String choice = read.nextLine();
            if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")){
                continue;
            } else if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("No")){
                break;
            }
        }
    }
}