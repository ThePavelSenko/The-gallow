package backend.academy;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GallowsInput {
    private final Scanner scanner;
    private final PrintStream out;

    // when creating an object, you can transfer any input and output streams
    public GallowsInput(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public char playerInputLetter() {
        String str;
        out.print("Enter letter: ");
        str = scanner.nextLine().toLowerCase();

        // If the input is incorrect, the loop continues
        while (str.length() != 1 || !Character.isLetter(str.charAt(0))) {
            out.print("Invalid input. Please enter a single letter: ");
            str = scanner.nextLine();
        }
        return str.charAt(0);
    }

    public void printMessage(String message) {
        out.println(message);
    }

    public String getDifficulty() {
        out.println("Enter the difficulty easy/medium/hard: ");
        return scanner.nextLine();
    }

    public String getCategory() {
        out.println("Enter the category animals/food/colors: ");
        return scanner.nextLine();
    }
}
