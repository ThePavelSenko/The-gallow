package backend.academy;

import static backend.academy.Stream.SCANNER;
import static backend.academy.Stream.OUT;


public class GallowsInput {

    public char playerInputLetter() {
        String str;
        OUT.print("Enter letter: ");
        str = SCANNER.nextLine().toUpperCase();
        OUT.println();
        // If the input is incorrect, the loop continues
        while (str.length() != 1 || !Character.isLetter(str.charAt(0))) {
            OUT.print("Invalid input. Please enter a single letter: ");
            str = SCANNER.nextLine().toUpperCase();
        }
        return str.charAt(0);
    }

    public void printMessage(String message) {
        OUT.println(message);
    }

    public String getDifficulty() {
        OUT.println("Enter the difficulty easy/medium/hard: ");
        return SCANNER.nextLine();
    }

    public String getCategory() {
        OUT.println("Enter the category animals/food/colors: ");
        return SCANNER.nextLine();
    }
}
