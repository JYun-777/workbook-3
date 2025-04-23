package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchTest {

    public static Scanner read = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            try{
                String[] names = {
                        "Ezra", "Elisha", "Ian",
                        "Siddalee", "Pursalane", "Zephaniah"
                };
                System.out.println("Pick a Kid");
                int i = read.nextInt();
                read.nextLine();
                System.out.println(names[i]);
                break;
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Out of index range");
                e.printStackTrace();
                read.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Need to enter an Int");
                e.printStackTrace();
                read.nextLine();
            }
            catch(Exception e){
                System.out.println("Something went wrong.");
                e.printStackTrace();
                read.nextLine();
            }
            System.out.println("Program continues");
        }
    }
}
