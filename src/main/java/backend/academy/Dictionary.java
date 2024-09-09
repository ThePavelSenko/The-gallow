package backend.academy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Dictionary {

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

    // The logic of initialize word
    public static String initializeWord(String difficulty, String category) throws IllegalArgumentException {
        List<String> words = new ArrayList<>();
        Random random = new Random();
        String finalDifficulty = difficulty;
        String finalCategory = category;

        if (!DIFFICULTIES.contains(difficulty)) {
            finalDifficulty = DIFFICULTIES.get(new Random().nextInt(DIFFICULTIES.size()));
        }

        if (!CATEGORIES.contains(category)) {
            finalCategory = CATEGORIES.get(new Random().nextInt(CATEGORIES.size()));
        }

        switch (finalCategory) {
            case ANIMALS:
                if (finalDifficulty.equals(EASY)) {
                    words = Arrays.asList("cat", "dog", "pig");
                } else if (finalDifficulty.equals(MEDIUM)) {
                    words = Arrays.asList("horse", "tiger", "panda");
                } else if (finalDifficulty.equals(HARD)) {
                    words = Arrays.asList("cheetah", "giraffe", "leopard");
                }
                break;

            case FOOD:
                if (finalDifficulty.equals(EASY)) {
                    words = Arrays.asList("pie", "egg", "ham");
                } else if (finalDifficulty.equals(MEDIUM)) {
                    words = Arrays.asList("chips", "toast", "pizza");
                } else if (finalDifficulty.equals(HARD)) {
                    words = Arrays.asList("chicken", "sausage", "pumpkin");
                }
                break;

            case COLORS:
                if (finalDifficulty.equals(EASY)) {
                    words = Arrays.asList("red", "pink", "blue");
                } else if (finalDifficulty.equals(MEDIUM)) {
                    words = Arrays.asList("black", "white", "green");
                } else if (finalDifficulty.equals(HARD)) {
                    words = Arrays.asList("orange", "yellow", "purple");
                }
                break;

            default:
                throw new IllegalArgumentException();
        }

        return words.get(random.nextInt(words.size()));
    }
}
