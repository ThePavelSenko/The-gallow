package backend.academy;

import java.util.Scanner;
import static backend.academy.GameLogic.MAX_DEFAULT_ATTEMPTS;
import static backend.academy.Stream.OUT;

public class GallowsInput {

    public char playerInputLetter() {
        Scanner scanner = new Scanner(System.in);
        String str;
        OUT.print("Enter letter: ");
        str = scanner.nextLine().toUpperCase();
        OUT.println();

        while (str.length() != 1 || !Character.isLetter(str.charAt(0))) {
            OUT.print("Invalid input. Please enter a single letter: ");
            str = scanner.nextLine().toUpperCase();
        }
        return str.charAt(0);
    }

    public void printMessage(String message) {
        OUT.println(message);
    }

    public String getDifficulty() {
        Scanner scanner = new Scanner(System.in);  // Создаем новый Scanner
        OUT.println("Enter the difficulty easy/medium/hard: ");
        return scanner.nextLine();
    }

    public String getCategory() {
        Scanner scanner = new Scanner(System.in);  // Создаем новый Scanner
        OUT.println("Enter the category animals/food/colors: ");
        return scanner.nextLine();
    }

    public int getMaxAttempts() {
        Scanner scanner = new Scanner(System.in);  // Создаем новый Scanner
        OUT.println("Enter a maximum of 9 attempts (6 by default): ");
        String attempts = scanner.nextLine();
        if (attempts.isEmpty()) {
            return MAX_DEFAULT_ATTEMPTS;
        }
        if (attempts.length() != 1 || !Character.isDigit(attempts.charAt(0))) {
            return MAX_DEFAULT_ATTEMPTS;
        } else {
            return Integer.parseInt(attempts);
        }
    }
}
