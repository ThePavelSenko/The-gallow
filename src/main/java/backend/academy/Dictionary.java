package backend.academy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import static backend.academy.Utils.getRandomValue;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dictionary {

    private static final Map<String, List<WordData>> WORDS = initializeWords();

    private static Map<String, List<WordData>> initializeWords() {
        Map<String, List<WordData>> words = new HashMap<>();

        words.put("animals:easy", Arrays.asList(
            new WordData("CAT", "A small domesticated carnivorous mammal"),
            new WordData("DOG", "A domesticated carnivorous mammal"),
            new WordData("PIG", "A domesticated hoofed animal")
        ));
        words.put("animals:medium", Arrays.asList(
            new WordData("HORSE", "A large plant-eating domesticated mammal"),
            new WordData("TIGER", "A large carnivorous feline mammal"),
            new WordData("PANDA", "A large bear-like mammal native to China")
        ));
        words.put("animals:hard", Arrays.asList(
            new WordData("CHEETAH", "A large spotted cat that can run fast"),
            new WordData("GIRAFFE", "A tall African mammal with a very long neck"),
            new WordData("LEOPARD", "A large, powerful, spotted wild cat")
        ));

        words.put("food:easy", Arrays.asList(
            new WordData("PIE", "A baked dish of fruit, or meat and vegetables"),
            new WordData("EGG", "An oval or round object laid by a female bird"),
            new WordData("HAM", "Meat from the upper part of a pig’s leg")
        ));
        words.put("food:medium", Arrays.asList(
            new WordData("CHIPS", "Thin slices of potato that have been fried"),
            new WordData("TOAST", "Sliced bread browned on both sides"),
            new WordData("PIZZA", "A dish of Italian origin, made with dough")
        ));
        words.put("food:hard", Arrays.asList(
            new WordData("CHICKEN", "A domestic fowl kept for eggs or meat"),
            new WordData("SAUSAGE", "Ground meat mixed with seasoning and encased"),
            new WordData("PUMPKIN", "A large round vegetable with thick orange skin")
        ));

        words.put("colors:easy", Arrays.asList(
            new WordData("RED", "The color at the long-wavelength end of the spectrum"),
            new WordData("PINK", "A pale red color"),
            new WordData("BLUE", "The color of the sky on a clear day")
        ));
        words.put("colors:medium", Arrays.asList(
            new WordData("BLACK", "The absence of color"),
            new WordData("WHITE", "The color produced by the reflection of all wavelengths of light"),
            new WordData("GREEN", "The color of grass and leaves")
        ));
        words.put("colors:hard", Arrays.asList(
            new WordData("ORANGE", "A bright reddish-yellow color"),
            new WordData("YELLOW", "The color between green and orange in the spectrum"),
            new WordData("PURPLE", "A color intermediate between red and blue")
        ));

        return words;
    }

    // Lists of difficulties and categories
    private static final List<String> CATEGORIES = Arrays.asList("animals", "food", "colors");
    private static final List<String> DIFFICULTIES = Arrays.asList("easy", "medium", "hard");

    // The logic of initialize word
    public static WordData getWord(String difficulty, String category) {
        String finalDifficulty;
        String finalCategory;

        if (!DIFFICULTIES.contains(difficulty)) {
            finalDifficulty = getRandomValue(DIFFICULTIES);
        } else {
            finalDifficulty = difficulty;
        }

        if (!CATEGORIES.contains(category)) {
            finalCategory = getRandomValue(CATEGORIES);
        } else {
            finalCategory = category;
        }

        return getRandomValue(WORDS.get(finalCategory + ":" + finalDifficulty));
    }
}
