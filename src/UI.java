package src;

import java.util.Scanner;

public class UI {
    Password password;
    Scanner in = new Scanner(System.in);


    public UI() {
        password = new Password();
    }

    public void start() {
        System.out.println("Welcome to GrantsEpicPasswordGenerator™, press enter to begin.");
        in.nextLine();
        System.out.println("\n\n\n");

        // set the users options for the password before it is created.
        password.setOptions();

        // generate the password.
        password.generate();

        // get the password to display it to the user.
        password.get();
    }
}
