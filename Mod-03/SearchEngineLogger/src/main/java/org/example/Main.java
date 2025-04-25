package org.example;

import java.io.*;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

    public static Scanner read = new Scanner(System.in);
    public static String searchTerm;

    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("logs.txt");
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            //Log Launch App
            TimeStamp.log(bufWriter, "launch");



            //Prompt to Search for Term
            while(true) {
                System.out.println("Enter a search term (X to exit): ");
                searchTerm = read.nextLine();
                if (searchTerm.equalsIgnoreCase("X")) {
                    break;
                } else {
                    TimeStamp.log(bufWriter, String.format("search: %s", searchTerm));
                }
            }
            //Log Exit app

            TimeStamp.log(bufWriter, "exit");
            bufWriter.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}