package backend.academy;

import java.io.PrintStream;
import java.util.Set;
import static backend.academy.GameLogic.MAX_DEFAULT_ATTEMPTS;

public class ViewOfTheGallows {
    private final PrintStream out;

    public ViewOfTheGallows(PrintStream out) {
        this.out = out;
    }

    private static final String[] GALLOWS_PICS = createGallowsPics();

    private static String[] createGallowsPics() {
        String emptyRow = "      |\n";
        String baseRow = "=========\n";
        String headRow = "  O   |\n";
        String torsoRow = "  |   |\n";
        String leftArmRow = " /|   |\n";
        String bothArmsRow = " /|\\  |\n";
        String leftLegRow = " /    |\n";
        String bothLegsRow = " / \\  |\n";
        String topRow = "  +---+\n";

        return new String[]{
            topRow + emptyRow + emptyRow + emptyRow + emptyRow + baseRow,
            topRow + headRow + emptyRow + emptyRow + emptyRow + baseRow,
            topRow + headRow + torsoRow + emptyRow + emptyRow + baseRow,
            topRow + headRow + leftArmRow + emptyRow + emptyRow + baseRow,
            topRow + headRow + bothArmsRow + emptyRow + emptyRow + baseRow,
            topRow + headRow + bothArmsRow + leftLegRow + emptyRow + baseRow,
            topRow + headRow + bothArmsRow + bothLegsRow + emptyRow + baseRow
        };
    }

    public void displayWord(String wordToGuess, Set<Character> guessedLetters) {
        StringBuilder word = new StringBuilder();
        word.append("Word: ");
        for (int i = 0; i < wordToGuess.length(); i++) {
            char c = wordToGuess.charAt(i);
            if (guessedLetters.contains(c)) {
                word.append(c);
            } else {
                word.append("-");
            }
            if (i < wordToGuess.length() - 1) {
                word.append(" ");
            }
        }
        this.out.print(word);
    }


    public void displayGallows(int countAttempts) {
        if (countAttempts > MAX_DEFAULT_ATTEMPTS) {
            this.out.println(GALLOWS_PICS[0]);
        } else if (countAttempts < MAX_DEFAULT_ATTEMPTS) {
            this.out.println(GALLOWS_PICS[MAX_DEFAULT_ATTEMPTS - countAttempts]);
        } else {
            this.out.println(GALLOWS_PICS[GALLOWS_PICS.length - countAttempts - 1]);
        }
    }

    public void displayAttemptsLeft(int attemptsLeft) {
        this.out.println("\nAttempts left: " + attemptsLeft);
    }

    public void helloMessage() {
        this.out.println("Welcome to the Gallows game!");
    }

    public void hintMessage() {
        this.out.println("Do you want to get a hint? Input please \"Y\" if you want or another letter if don't want: ");
    }
}
