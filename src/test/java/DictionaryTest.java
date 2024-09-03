import backend.academy.Dictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DictionaryTest {

    @Test
    void testDefaultConstructor() {
        Dictionary dictionary = new Dictionary();
        assertThat(dictionary.getRandomWord()).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"easy", "medium", "hard"})
    void testConstructorWithDifficulty(String difficulty) {
        Dictionary dictionary = new Dictionary(difficulty);
        assertThat(dictionary.getRandomWord()).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({
        "easy, colors",
        "medium, colors",
        "hard, colors"
    })
    void testGetRandomWord(String difficulty, String category) {
        // Given: определенная сложность и категория
        Dictionary dictionary = new Dictionary(difficulty, category);

        List<String> possibleWords;
        switch (category) {
            case "colors":
                if (difficulty.equals("easy")) {
                    possibleWords = List.of("red", "pink", "blue");
                } else if (difficulty.equals("medium")) {
                    possibleWords = List.of("black", "white", "green");
                } else {
                    possibleWords = List.of("orange", "yellow", "purple");
                }
                break;

            case "animals":
                if (difficulty.equals("easy")) {
                    possibleWords = List.of("cat", "dog", "pig");
                } else if (difficulty.equals("medium")) {
                    possibleWords = List.of("horse", "tiger", "panda");
                } else {
                    possibleWords = List.of("cheetah", "giraffe", "leopard");
                }
                break;

            case "food":
                if (difficulty.equals("easy")) {
                    possibleWords = List.of("pie", "egg", "ham");
                } else if (difficulty.equals("medium")) {
                    possibleWords = List.of("chips", "toast", "pizza");
                } else {
                    possibleWords = List.of("chicken", "sausage", "pumpkin");
                }
                break;

            default:
                throw new IllegalStateException("Unexpected category: " + category);
        }

        // When: получение случайного слова из словаря
        String word = dictionary.getRandomWord();

        // Then: проверка, что слово находится в списке возможных слов
        assertThat(possibleWords).contains(word);
    }

    @Test
    void testInvalidDifficulty() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Dictionary("invalidDifficulty", "colors");
        });
        assertThat(exception.getMessage()).isEqualTo("Invalid difficulty: invalidDifficulty");
    }

    @Test
    void testInvalidCategory() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Dictionary("easy", "invalidCategory");
        });
        assertThat(exception.getMessage()).isEqualTo("Invalid category: invalidCategory");
    }
}
