package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner read = new Scanner(System.in);
    public static String[] quotes = {
            "Never tell me the odds.",
            "Every journey has it's ending. Don't rush.",
            "Sleep is just a rehearsal for death.",
            "Making the mother of all omelettes here, can't stress out over a few eggs.",
            "The enemy gate is down.",
            "I can't go to hell. I'm all out of vacation days."
    };
    public static void main(String[] args) {
        while (true) {
            System.out.println("Type 1-10 for a quote, or -1 for a random quote.");
            int choice = read.nextInt();
            try {
                if (choice == -1){
                    int randomChoice = (int) (Math.random() * quotes.length);
                    System.out.println(quotes[randomChoice]);
                }else{
                    System.out.println(quotes[choice - 1]);
                }
            } catch (Exception e) {
                System.out.println("Out of range");
            }

            System.out.println("Would you like to see another quote?\n1 for Yes, 2 for no.");
            choice = read.nextInt();
            if (choice == 2) System.exit(0);
        }
    }
}