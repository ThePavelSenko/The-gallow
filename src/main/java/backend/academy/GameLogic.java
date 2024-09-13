package backend.academy;

import java.util.HashSet;
import java.util.Set;
import static backend.academy.GallowsInput.SCANNER;
import static backend.academy.Stream.OUT;

public class GameLogic {
    public static final int MAX_ATTEMPTS = 6;
    GallowsInput gallowsInput;
    private final String secretWord;
    private String hiddenWord;
    private int attemptsLeft;
    private Set<Character> guessedLetters;
    private Set<Character> incorrectLetters;
    private ViewOfTheGallows view;

    private int errorsCount = 0;

    public GameLogic(String secretWord, ViewOfTheGallows view, GallowsInput gallowsInput) {
        this.gallowsInput = gallowsInput;
        this.view = view;
        this.secretWord = secretWord;
        this.hiddenWord = generateHiddenWord(secretWord.length());
        this.attemptsLeft = gallowsInput.getMaxAttempts();
        this.guessedLetters = new HashSet<>();
        this.incorrectLetters = new HashSet<>();
    }

    private String generateHiddenWord(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("_");
        }
        return sb.toString();
    }

    public boolean guess(char letter) {
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

    public boolean isWordGuessed() {
        return secretWord.equals(hiddenWord);
    }

    public boolean isGameOver() {
        return attemptsLeft == 0;
    }

    public void resetGame() {
        attemptsLeft = MAX_ATTEMPTS;
        guessedLetters.clear();
        incorrectLetters.clear();
        errorsCount = 0;
        hiddenWord = generateHiddenWord(secretWord.length());

    }

    public void play() {
        while (!isGameOver()) {
            view.displayWord(hiddenWord, guessedLetters);
            view.displayAttemptsLeft(attemptsLeft);
            view.displayGallows(attemptsLeft);
            char letter = gallowsInput.playerInputLetter();

            if (guess(letter)) {
                if (isWordGuessed()) {
                    view.displayWord(hiddenWord, guessedLetters);
                    gallowsInput.printMessage("You have won!");
                    OUT.println();
                    return;
                } else {
                    gallowsInput.printMessage("Try again!");
                }
            }
        }
        view.displayGallows(attemptsLeft);
        gallowsInput.printMessage("You have lost! Secret word was: " + secretWord);
        OUT.println();
    }


    public void run() {
        boolean button = false;
        GallowsInput input = new GallowsInput();
        input.printMessage("Press N to start a new game or Q to quit.");

        char response;
        do {
            response = input.playerInputLetter();
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

        SCANNER.close();
    }
}
