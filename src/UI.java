package src;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class UI {
    Password password;
    Scanner in = new Scanner(System.in);

    int length;
    boolean hasSymbols;
    boolean hasCaps;
    boolean hasNums;


    public UI() {
        password = new Password();
        length = 0;
        hasCaps = false;
        hasSymbols = false;
        hasNums = false;
    }

    public void start() {
        System.out.println("Welcome to GrantsEpicPasswordGenerator™, press enter to begin.");
        in.nextLine();
        System.out.println("\n\n\n");

        setOptions();
    }

    private void setOptions() {
        boolean isDone = false;
        String temp = "";


        while (!isDone) {
            temp = getInput("Would you like your password to include capitals? (Y/N)");
            if (temp.toLowerCase().equals("y")) {
                hasCaps = true;
                isDone = true;
            } else if (temp.toLowerCase().equals("n")) {
                hasCaps = false;
                isDone = true;
            } else {
                System.out.println("Please respond with ether \"Y\" or \"N\".");
            }
        }


        isDone = false;
        while (!isDone) {
            temp = getInput("Numbers? (Y/N)");
            if (temp.toLowerCase().equals("y")) {
                hasNums = true;
                isDone = true;
            } else if (temp.toLowerCase().equals("n")) {
                hasNums = false;
                isDone = true;
            } else {
                System.out.println("Please respond with ether \"Y\" or \"N\".");
            }
        }


        isDone = false;
        while (!isDone) {
            temp = getInput("Symbols? (Y/N)");
            if (temp.toLowerCase().equals("y")) {
                hasSymbols = true;
                isDone = true;
            } else if (temp.toLowerCase().equals("n")) {
                hasSymbols = false;
                isDone = true;
            } else {
                System.out.println("Please respond with ether \"Y\" or \"N\".");
            }
        }


        isDone = false;
        while (!isDone) {
            temp = getInput("How long would you like your password?");
            try {
                length = Integer.parseInt(temp);
                if (length <= 0 || length > 48) {
                    System.out.println("Passwords must be 1 or more digits and under 48 digits long.");
                    continue;
                }
                isDone = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid Int number.");
            }
        }
    }

    private String getInput(String inputMessage) {
        System.out.println(inputMessage);
        System.out.print("> ");
        return in.nextLine();
    }
}
