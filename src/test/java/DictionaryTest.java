import backend.academy.Dictionary;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class DictionaryTest {

    @ParameterizedTest
    @CsvSource({
        "easy, colors",
        "medium, colors",
        "hard, colors",
        "easy, animals",
        "medium, animals",
        "hard, animals",
        "easy, food",
        "medium, food",
        "hard, food"
    })
    void testGetDictionaryRandomWord(String difficulty, String category) {
        // Calling a method with valid data
        String word = Dictionary.initializeWord(difficulty.toLowerCase(), category.toLowerCase()).toUpperCase();

        // Checking that the word is included in the list of possible words
        List<String> possibleWords = switch (category) {
            case "colors" -> switch (difficulty) {
                case "easy" -> List.of("RED", "PINK", "BLUE");
                case "medium" -> List.of("BLACK", "WHITE", "GREEN");
                case "hard" -> List.of("ORANGE", "YELLOW", "PURPLE");
                default -> throw new IllegalStateException("Unexpected difficulty: " + difficulty);
            };
            case "animals" -> switch (difficulty) {
                case "easy" -> List.of("CAT", "DOG", "PIG");
                case "medium" -> List.of("HORSE", "TIGER", "PANDA");
                case "hard" -> List.of("CHEETAH", "GIRAFFE", "LEOPARD");
                default -> throw new IllegalStateException("Unexpected difficulty: " + difficulty);
            };
            case "food" -> switch (difficulty) {
                case "easy" -> List.of("PIE", "EGG", "HAM");
                case "medium" -> List.of("CHIPS", "TOAST", "PIZZA");
                case "hard" -> List.of("CHICKEN", "SAUSAGE", "PUMPKIN");
                default -> throw new IllegalStateException("Unexpected difficulty: " + difficulty);
            };
            default -> throw new IllegalStateException("Unexpected category: " + category);
        };

        assertThat(possibleWords).contains(word);
    }
}
