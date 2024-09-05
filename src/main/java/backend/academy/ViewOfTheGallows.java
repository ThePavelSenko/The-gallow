package backend.academy;

import java.util.Set;
import java.util.logging.Logger;

public class ViewOfTheGallows {

    private static final String[] GALLOWS_PICS = createGallowsPics();
    private static final Logger LOGGER = Logger.getLogger(ViewOfTheGallows.class.getName());

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
        for (char c : wordToGuess.toCharArray()) {
            if (guessedLetters.contains(c)) {
                word.append(c);
            } else {
                word.append("-");
            }
            word.append(" ");
        }
        LOGGER.info(word.toString());
    }

    public void displayGallows(int countAttempts) {
        LOGGER.info(GALLOWS_PICS[GALLOWS_PICS.length - countAttempts - 1]);
    }

    public void displayAttemptsLeft(int attemptsLeft) {
        LOGGER.info("Attempts left: " + attemptsLeft);
    }
}
