import backend.academy.Dictionary;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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
    void testGetDictionaryRandomWordWithValidInputs(String difficulty, String category) {
        // When: calling a method with valid data
        String word = Dictionary.getDictionaryRandomWord(difficulty, category);

        // Then: checking that the word is included in the list of possible words
        List<String> possibleWords = switch (category) {
            case "colors" -> switch (difficulty) {
                case "easy" -> List.of("red", "pink", "blue");
                case "medium" -> List.of("black", "white", "green");
                case "hard" -> List.of("orange", "yellow", "purple");
                default -> throw new IllegalStateException("Unexpected difficulty: " + difficulty);
            };
            case "animals" -> switch (difficulty) {
                case "easy" -> List.of("cat", "dog", "pig");
                case "medium" -> List.of("horse", "tiger", "panda");
                case "hard" -> List.of("cheetah", "giraffe", "leopard");
                default -> throw new IllegalStateException("Unexpected difficulty: " + difficulty);
            };
            case "food" -> switch (difficulty) {
                case "easy" -> List.of("pie", "egg", "ham");
                case "medium" -> List.of("chips", "toast", "pizza");
                case "hard" -> List.of("chicken", "sausage", "pumpkin");
                default -> throw new IllegalStateException("Unexpected difficulty: " + difficulty);
            };
            default -> throw new IllegalStateException("Unexpected category: " + category);
        };

        assertThat(possibleWords).contains(word);
    }
}
