package backend.academy;

import java.io.PrintStream;
import java.util.Set;

public class ViewOfTheGallows {
    private static final String[] GALLOWS_PICS = createGallowsPics();
    private final PrintStream out;

    // when creating an object, you can transfer any output streams
    public ViewOfTheGallows(PrintStream out) {
        this.out = out;
    }

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
        out.print(word.toString());
    }


    public void displayGallows(int countAttempts) {
        out.println(GALLOWS_PICS[GALLOWS_PICS.length - countAttempts - 1]);
    }

    public void displayAttemptsLeft(int attemptsLeft) {
        out.println("\nAttempts left: " + attemptsLeft);
    }

    public void helloMessage() {
        out.println("Welcome to the Gallows game!");
    }
}
