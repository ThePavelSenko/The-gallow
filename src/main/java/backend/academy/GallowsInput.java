package backend.academy;

import java.util.Scanner;
import java.util.logging.Logger;

public class GallowsInput {
    private static final Logger LOGGER = Logger.getLogger(GallowsInput.class.getName());
    private static Scanner scanner;

    public GallowsInput() {
        scanner = new Scanner(System.in);
    }

    public char playerInputLetter() {
        String str;
        LOGGER.info("Enter letter: ");
        str = scanner.nextLine();

        // If the input is correct, the cycle don't start
        while (str.length() != 1 || !Character.isLetter(str.charAt(0))) {
            LOGGER.warning("Invalid input. Please enter a single letter: ");
            str = scanner.nextLine();
        }
        return str.charAt(0);
    }
}
