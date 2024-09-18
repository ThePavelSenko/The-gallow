package backend.academy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import static backend.academy.Utils.getRandomValue;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

    private static final Map<String, Map<String, List<WordData>>> WORDS = new HashMap<>();

    public static void initializeWords() {
        addWord(ANIMALS, EASY, new WordData("CAT", "A small domesticated carnivorous mammal"));
        addWord(ANIMALS, EASY, new WordData("DOG", "A domesticated carnivorous mammal"));
        addWord(ANIMALS, EASY, new WordData("PIG", "A domesticated hoofed animal"));

        addWord(ANIMALS, MEDIUM, new WordData("HORSE", "A large plant-eating domesticated mammal"));
        addWord(ANIMALS, MEDIUM, new WordData("TIGER", "A large carnivorous feline mammal"));
        addWord(ANIMALS, MEDIUM, new WordData("PANDA", "A large bear-like mammal native to China"));

        addWord(ANIMALS, HARD, new WordData("CHEETAH", "A large spotted cat that can run fast"));
        addWord(ANIMALS, HARD, new WordData("GIRAFFE", "A tall African mammal with a very long neck"));
        addWord(ANIMALS, HARD, new WordData("LEOPARD", "A large, powerful, spotted wild cat"));

        addWord(FOOD, EASY, new WordData("PIE", "A baked dish of fruit, or meat and vegetables"));
        addWord(FOOD, EASY, new WordData("EGG", "An oval or round object laid by a female bird"));
        addWord(FOOD, EASY, new WordData("HAM", "Meat from the upper part of a pig’s leg"));

        addWord(FOOD, MEDIUM, new WordData("CHIPS", "Thin slices of potato that have been fried"));
        addWord(FOOD, MEDIUM, new WordData("TOAST", "Sliced bread browned on both sides"));
        addWord(FOOD, MEDIUM, new WordData("PIZZA", "A dish of Italian origin, made with dough"));

        addWord(FOOD, HARD, new WordData("CHICKEN", "A domestic fowl kept for eggs or meat"));
        addWord(FOOD, HARD, new WordData("SAUSAGE", "Ground meat mixed with seasoning and encased"));
        addWord(FOOD, HARD, new WordData("PUMPKIN", "A large round vegetable with thick orange skin"));

        addWord(COLORS, EASY, new WordData("RED", "The color at the long-wavelength end of the spectrum"));
        addWord(COLORS, EASY, new WordData("PINK", "A pale red color"));
        addWord(COLORS, EASY, new WordData("BLUE", "The color of the sky on a clear day"));

        addWord(COLORS, MEDIUM, new WordData("BLACK", "The absence of color"));
        addWord(COLORS, MEDIUM, new WordData("WHITE", "The color of the tooth of Hollywood stars"));
        addWord(COLORS, MEDIUM, new WordData("GREEN", "The color of grass and leaves"));

        addWord(COLORS, HARD, new WordData("ORANGE", "A bright reddish-yellow color"));
        addWord(COLORS, HARD, new WordData("YELLOW", "The color between green and orange in the spectrum"));
        addWord(COLORS, HARD, new WordData("PURPLE", "A color intermediate between red and blue"));
    }


    // The logic of initialize word
    public static WordData getWordData(String difficulty, String category) {
        String finalDifficulty = (difficulty != null && !difficulty.isEmpty() && DIFFICULTIES.contains(difficulty.toLowerCase()))
            ? difficulty.toLowerCase()
            : getRandomValue(DIFFICULTIES);

        String finalCategory = (category != null && !category.isEmpty() && CATEGORIES.contains(category.toLowerCase()))
            ? category.toLowerCase()
            : getRandomValue(CATEGORIES);

        Map<String, List<WordData>> categoryWords = WORDS.get(finalCategory);
        if (categoryWords == null || categoryWords.isEmpty()) {
            finalCategory = getRandomValue(CATEGORIES);
            categoryWords = WORDS.get(finalCategory);
        }

        List<WordData> wordList = categoryWords.get(finalDifficulty);
        if (wordList == null || wordList.isEmpty()) {
            finalDifficulty = getRandomValue(DIFFICULTIES);
            wordList = categoryWords.get(finalDifficulty);
        }

        return getRandomValue(wordList);
    }


    private static void addWord(String category, String difficulty, WordData wordData) {
        WORDS.putIfAbsent(category, new HashMap<>());
        WORDS.get(category).putIfAbsent(difficulty, new ArrayList<>());
        WORDS.get(category).get(difficulty).add(wordData);
    }
}
