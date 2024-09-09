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
                    words = Arrays.asList("CAT", "DOG", "PIG");
                } else if (finalDifficulty.equals(MEDIUM)) {
                    words = Arrays.asList("HORSE", "TIGER", "PANDA");
                } else if (finalDifficulty.equals(HARD)) {
                    words = Arrays.asList("CHEETAH", "GIRAFFE", "LEOPARD");
                }
                break;

            case FOOD:
                if (finalDifficulty.equals(EASY)) {
                    words = Arrays.asList("PIE", "EGG", "HAM");
                } else if (finalDifficulty.equals(MEDIUM)) {
                    words = Arrays.asList("CHIPS", "TOAST", "PIZZA");
                } else if (finalDifficulty.equals(HARD)) {
                    words = Arrays.asList("CHICKEN", "SAUSAGE", "PUMPKIN");
                }
                break;

            case COLORS:
                if (finalDifficulty.equals(EASY)) {
                    words = Arrays.asList("RED", "PINK", "BLUE");
                } else if (finalDifficulty.equals(MEDIUM)) {
                    words = Arrays.asList("BLACK", "WHITE", "GREEN");
                } else if (finalDifficulty.equals(HARD)) {
                    words = Arrays.asList("ORANGE", "YELLOW", "PURPLE");
                }
                break;

            default:
                throw new IllegalArgumentException();
        }

        return words.get(random.nextInt(words.size()));
    }
}
