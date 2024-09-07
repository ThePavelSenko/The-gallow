package backend.academy;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

public class GameLogic {
    @Getter static final int MAX_ATTEMPTS = 6;
    GallowsInput gallowsInput;
    @Getter private String secretWord;
    @Getter private String hiddenWord;
    private int attemptsLeft;
    @Getter Set<Character> guessedLetters;
    @Getter Set<Character> incorrectLetters;
    private ViewOfTheGallows view;
    private static final InputStream IN = System.in;
    private static final PrintStream OUT = System.out;

    private int errorsCount = 0;

    public GameLogic(String secretWord, ViewOfTheGallows view, GallowsInput gallowsInput) {
        this.gallowsInput = gallowsInput;
        this.view = view;
        this.secretWord = secretWord;
        this.hiddenWord = generateHiddenWord(secretWord.length());
        this.attemptsLeft = MAX_ATTEMPTS;
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
            view.displayGallows(attemptsLeft);
            view.displayWord(hiddenWord, guessedLetters);
            view.displayAttemptsLeft(attemptsLeft);
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
        gallowsInput.printMessage("You have lost! Secret word was: " + secretWord);
        OUT.println();
    }


    public void run() {
        boolean button = false;
        GallowsInput input = new GallowsInput(IN, OUT);
        input.printMessage("Welcome to the Gallows game!");
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
    }
}
