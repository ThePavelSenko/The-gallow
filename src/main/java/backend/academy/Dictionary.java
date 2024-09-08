package backend.academy;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
    private final String words;
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

    // Lists of difficulties and categories
    private static final List<String> CATEGORIES = Arrays.asList(ANIMALS, FOOD, COLORS);
    private static final List<String> DIFFICULTIES = Arrays.asList(EASY, MEDIUM, HARD);

    private Dictionary() {
        String df = DIFFICULTIES.get(new Random().nextInt(DIFFICULTIES.size()));
        String ctg = CATEGORIES.get(new Random().nextInt(CATEGORIES.size()));
        this.words = initializeWord(df, ctg);
    }

    private Dictionary(String df) {
        String ctg = CATEGORIES.get(new Random().nextInt(CATEGORIES.size()));
        this.words = initializeWord(df, ctg);
    }

    private Dictionary(String df, String ctg) {
        this.words = initializeWord(df, ctg);
    }

    // The logic of initialize word
    public static String initializeWord(String df, String ctg) {
        List<String> words = new ArrayList<>();
        Random random = new Random();

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
        }

        return words.get(random.nextInt(words.size()));
    }
}
