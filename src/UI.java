import java.util.Scanner;

public class UI {
    Password password;
    Scanner in = new Scanner(System.in);


    public UI() {
        password = new Password();
    }

    public void start() {
        clearScreen();
        System.out.println("Welcome to GrantsEpicPasswordGenerator™, press enter to begin.");
        in.nextLine();
        clearScreen();

        // set the users options for the password before it is created.
        password.setOptions();

        // generate the password.
        password.generate();

        // get the password and display it to the user.
        passwordOut(password.get());

        boolean cont = true;
        String temp = "";
        while (cont) {
            clearScreen();
            boolean isDone = false;
            while (!isDone) {
                temp = getInput("\n\nWould you like to generate another password? (Y/N)");
                if (temp.toLowerCase().equals("y")) {
                    isDone = true;
                } else if (temp.toLowerCase().equals("n")) {
                    clearScreen();
                    System.out.println("Thank you for using GrantsEpicPasswordGenerator™, I hope to see you again soon!");
                    return;
                } else {
                    System.out.println("Please respond with ether \"Y\" or \"N\".");
                }
            }

            isDone = false;
            while (!isDone) {
                temp = getInput("Would you like to use the same settings? (Y/N)");
                if (temp.toLowerCase().equals("y")) {
                    isDone = true;
                } else if (temp.toLowerCase().equals("n")) {
                    password.setOptions();
                    isDone = true;
                } else {
                    System.out.println("Please respond with ether \"Y\" or \"N\".");
                }
            }

            password.generate();
            passwordOut(password.get());
        }        
    }

    private void passwordOut(String password) {
        System.out.println("\n\nHere is your password:");
        System.out.println("-------------------------------");
        System.out.println("> " + password);
        System.out.print("\nPress enter to continue.");
        in.nextLine();
    }

    private String getInput(String inputMessage) {
        System.out.println(inputMessage);
        System.out.print("> ");
        return in.nextLine();
    }

    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
