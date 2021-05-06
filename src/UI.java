package src;

import java.util.Scanner;

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

        setOptions();
    }

    private void setOptions() {
        boolean isDone = false;
        while (!isDone) {
            
        }
    }

    private String getInput(String inputMessage) {
        System.out.println(inputMessage);
        System.out.print("> ");
        return in.nextLine();
    }
}
