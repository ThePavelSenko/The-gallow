package backend.academy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
    private final List<String> dictionary;
    static Scanner scanner = new Scanner(System.in);
    private static final PrintStream OUT = System.out;

    // Constants for categories
    private static final String ANIMALS = "animals";
    private static final String FOOD = "food";
    private static final String COLORS = "colors";

    // Constants for difficulties
    private static final String EASY = "easy";
    private static final String MEDIUM = "medium";
    private static final String HARD = "hard";

    // Constants for error message
    private static final String INVALID_DIFFICULTY = "Invalid difficulty: ";
    private static final String INVALID_CATEGORY = "Invalid category: ";

    // Lists of difficulties and categories
    private static final List<String> CATEGORIES = Arrays.asList(ANIMALS, FOOD, COLORS);
    private static final List<String> DIFFICULTIES = Arrays.asList(EASY, MEDIUM, HARD);

    private Dictionary() {
        String df = DIFFICULTIES.get(new Random().nextInt(DIFFICULTIES.size()));
        String ctg = CATEGORIES.get(new Random().nextInt(CATEGORIES.size()));
        this.dictionary = initializeDictionary(df, ctg);
    }

    private Dictionary(String df) throws IllegalArgumentException {
        if (!DIFFICULTIES.contains(df)) {
            throw new IllegalArgumentException(INVALID_DIFFICULTY + df);
        }
        String ctg = CATEGORIES.get(new Random().nextInt(CATEGORIES.size()));
        this.dictionary = initializeDictionary(df, ctg);
    }

    private Dictionary(String df, String ctg) throws IllegalArgumentException {
        if (!DIFFICULTIES.contains(df)) {
            throw new IllegalArgumentException(INVALID_DIFFICULTY + df);
        }
        if (!CATEGORIES.contains(ctg)) {
            throw new IllegalArgumentException(INVALID_CATEGORY + ctg);
        }
        this.dictionary = initializeDictionary(df, ctg);
    }

    // The logic of dictionary initialization
    private List<String> initializeDictionary(String df, String ctg)
        throws
        IllegalStateException,
        IllegalArgumentException {
        List<String> words = new ArrayList<>();

        switch (ctg) {
            case ANIMALS:
                if (df.equals(EASY)) {
                    words = Arrays.asList("cat", "dog", "pig");
                } else if (df.equals(MEDIUM)) {
                    words = Arrays.asList("horse", "tiger", "panda");
                } else if (df.equals(HARD)) {
                    words = Arrays.asList("cheetah", "giraffe", "leopard");
                }
                break;

            case FOOD:
                if (df.equals(EASY)) {
                    words = Arrays.asList("pie", "egg", "ham");
                } else if (df.equals(MEDIUM)) {
                    words = Arrays.asList("chips", "toast", "pizza");
                } else if (df.equals(HARD)) {
                    words = Arrays.asList("chicken", "sausage", "pumpkin");
                }
                break;

            case COLORS:
                if (df.equals(EASY)) {
                    words = Arrays.asList("red", "pink", "blue");
                } else if (df.equals(MEDIUM)) {
                    words = Arrays.asList("black", "white", "green");
                } else if (df.equals(HARD)) {
                    words = Arrays.asList("orange", "yellow", "purple");
                }
                break;

            default:
                throw new IllegalArgumentException(INVALID_CATEGORY + ctg);
        }

        if (words.isEmpty()) {
            throw new IllegalStateException("No words found for the given category and difficulty.");
        }

        return words;
    }

    private String createRandomWord() throws IllegalStateException {
        if (dictionary.isEmpty()) {
            throw new IllegalStateException("Dictionary is empty. No words available to choose from.");
        }
        Random rand = new Random();
        return dictionary.get(rand.nextInt(dictionary.size()));
    }

    public static String getDictionaryRandomWord(String difficulty, String category) {
        Dictionary dictionary;
        switch (difficulty) {
            case "easy", "medium", "hard" -> {
                switch (category) {
                    case "animals", "food", "colors" -> dictionary = new Dictionary(difficulty, category);
                    default -> dictionary = new Dictionary(difficulty);
                }
            }
            default -> dictionary = new Dictionary();
        }

        return dictionary.createRandomWord();
    }
}
