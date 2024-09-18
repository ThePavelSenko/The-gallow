package backend.academy;

import java.util.HashSet;
import java.util.Set;
import static backend.academy.Stream.OUT;
import static backend.academy.Stream.SCANNER;

public class GameLogic {
    public static final int MAX_DEFAULT_ATTEMPTS = 6;
    private static final int HINT_GET_STRING = 3;
    private GallowsInput gallowsInput;
    private final String secretWord;
    private String hiddenWord;
    private int attemptsLeft;
    private Set<Character> guessedLetters;
    private Set<Character> incorrectLetters;
    private ViewOfTheGallows view;
    private GallowsInput input;
    private String wordDescription;
    private int errorsCount = 0;

    public GameLogic(String secretWord, String wordDescription, ViewOfTheGallows view, GallowsInput gallowsInput) {
        this.gallowsInput = gallowsInput;
        this.view = view;
        this.secretWord = secretWord;
        this.hiddenWord = generateHiddenWord(secretWord.length());
        this.attemptsLeft = gallowsInput.getMaxAttempts(SCANNER);
        this.guessedLetters = new HashSet<>();
        this.incorrectLetters = new HashSet<>();
        this.input = new GallowsInput();
        this.wordDescription = wordDescription;
    }

    private String generateHiddenWord(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("_");
        }
        return sb.toString();
    }

    private boolean guess(char letter) {
        boolean isCorrect = false;

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                hiddenWord = hiddenWord.substring(0, i) + letter + hiddenWord.substring(i + 1);
                isCorrect = true;
            }
        }
        if (isCorrect) {
            guessedLetters.add(letter);
        } else {
            errorsCount++;
            attemptsLeft--;
            incorrectLetters.add(letter);
        }
        return isCorrect;
    }

    private boolean isWordGuessed() {
        return secretWord.equals(hiddenWord);
    }

    private boolean isGameOver() {
        return attemptsLeft == 0;
    }

    public void play() {
        int hint = 0;
        while (!isGameOver()) {
            view.displayWord(hiddenWord, guessedLetters);
            view.displayAttemptsLeft(attemptsLeft);
            view.displayGallows(attemptsLeft);

            char letter = gallowsInput.playerInputLetter(SCANNER);

            if (guess(letter)) {
                hint = 0;
                if (isWordGuessed()) {
                    view.displayWord(hiddenWord, guessedLetters);
                    gallowsInput.printMessage("\nYou have won!");
                    OUT.println();
                    return;
                }
            } else {
                hint++;
            }

            if (hint == HINT_GET_STRING) {
                view.hintMessage();
                char response = input.playerInputLetter(SCANNER);
                if (response == 'Y') {
                    OUT.println("HINT: " + wordDescription + "\n");
                }
                hint = 0;
            }
        }
        view.displayGallows(attemptsLeft);
        gallowsInput.printMessage("You have lost! Secret word was: " + secretWord);
        OUT.println();
    }


    public void run() {
        boolean button = false;
        input.printMessage("Press N to start a new game or Q to quit.");

        char response;
        do {
            response = input.playerInputLetter(SCANNER);
            if (response == 'N') {
                play();
                button = true;
            } else if (response == 'Q') {
                input.printMessage("Goodbye!");
                button = true;
            } else {
                input.printMessage("Invalid input, please try again.");
            }
        } while (!button);
    }
}
