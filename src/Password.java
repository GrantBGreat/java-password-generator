import java.util.Scanner;
import java.util.ArrayList;

public class Password {
    String password;
    Scanner in;

    int length;
    boolean hasSymbols;
    boolean hasCaps;
    boolean hasNums;

    // stuff for generation:
    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final String SYMOBOLS = "!@#&()–[{}]:;',?/*~$^+=<>";

    public Password() {
        password = "ERROR: PASSWORD NOT SET";

        in = new Scanner(System.in);

        length = 0;
        hasCaps = false;
        hasSymbols = false;
        hasNums = false;
    }

    public void generate() {
        // generate the password based off the users gived options.
        if (length == 0) {
            System.out.println("ERROR: Password generation settings not yet made.");
            return;
        }

        String chars2use = CHAR_LOWERCASE;
        if (hasCaps) {
            chars2use += CHAR_UPPERCASE;
        }
        if (hasSymbols) {
            chars2use += SYMOBOLS;
        }
        if (hasNums) {
            chars2use += DIGIT;
        }
    }

    public String get() {
        return password;
    }

    public void setOptions() {
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
                    System.out.println("Passwords must be 1 or more chars and under 48 chars long.");
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
