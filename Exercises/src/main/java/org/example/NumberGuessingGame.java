package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;



/*Challenge: Start with a good "Welcome to the game message"
Create a menu
Easy mode
or Hard mode
If picked 1
It wil generate a number between 1 and 10
if picked 2it will generate a number between 1 and 100
Bonus challenge … hard mode (only 5 tries)*/

public class NumberGuessingGame
{

    public static Scanner read = new Scanner(System.in);

    public static void main(String[] args){
        gameMenu();
    }

    public static void gameMenu(){
        System.out.println("Welcome to the Number Guessing Game!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("Please choose your difficulty:\n 1. Easy mode- Guess a number from 1 to 10 within 10 tries\n" +
                " 2. Hard mode - Guess a number from 1 to 100 within 5 tries\n>>");
        int choice = read.nextInt();
        read.nextLine();
        if (choice == 1){
            playGame(1,10,10);
        }
        if (choice == 2){
            playGame(1,100,5);
        }
    }

    public static void playGame(int minimum, int maximum, int tryLimit){
        boolean success = false;

        //choose random num
        int correctNumber = (int) (Math.random() * maximum) + minimum;
        int tryCount = tryLimit;



        while(!success)
        {
            try {
                System.out.printf("Pick a number (between %d - %d): ", minimum, maximum);
                int guessedNumber = read.nextInt();
                read.nextLine(); // clear newline

                if (guessedNumber < minimum || guessedNumber > maximum) {
                    System.out.printf(" Number out of range. Pick between %d and %d.", minimum, maximum);
                    continue;
                }
                if (guessedNumber != correctNumber) {
                    if (guessedNumber > correctNumber) {
                        System.out.println("Too high");
                    }
                    if (guessedNumber < correctNumber) {
                        System.out.println("Too low");
                    }
                    --tryCount;
                    if (tryCount == 0){
                        System.out.printf("Wrong. You are out of tries, the answer was %d.\nGame over.\n", correctNumber);
                        replayGamePrompt();
                    }else{
                        System.out.printf("Wrong. You have %d tries left.\n", tryCount);
                        continue;
                    }
                }
                System.out.println("You guessed it correct!");
                replayGamePrompt();
                success = true;
                break;
            } catch (InputMismatchException e) {
                System.out.println(" Not a valid number. Please enter digits only.");
                read.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("⚠️ Something else went wrong: " + e.getMessage());
                read.nextLine();
            }
        }

        read.close();
    }

    public static void clearConsole(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void replayGamePrompt(){
        System.out.print("Try again? 1 for Yes, 2 for No: ");
        int replay = read.nextInt();
        if (replay == 1) {
            clearConsole();
            gameMenu();
        }
        else {
            System.out.println("Goodbye");
            System.exit(0);
        }
    }
}
