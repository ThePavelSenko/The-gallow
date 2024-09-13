import backend.academy.Dictionary;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DictionaryTest {

    static Stream<Arguments> dictionaryParameters() {
        return Stream.of(
            Arguments.of("easy", "colors", List.of("RED", "PINK", "BLUE")),
            Arguments.of("medium", "colors", List.of("BLACK", "WHITE", "GREEN")),
            Arguments.of("hard", "colors", List.of("ORANGE", "YELLOW", "PURPLE")),
            Arguments.of("easy", "animals", List.of("CAT", "DOG", "PIG")),
            Arguments.of("medium", "animals", List.of("HORSE", "TIGER", "PANDA")),
            Arguments.of("hard", "animals", List.of("CHEETAH", "GIRAFFE", "LEOPARD")),
            Arguments.of("easy", "food", List.of("PIE", "EGG", "HAM")),
            Arguments.of("medium", "food", List.of("CHIPS", "TOAST", "PIZZA")),
            Arguments.of("hard", "food", List.of("CHICKEN", "SAUSAGE", "PUMPKIN"))
        );
    }

    @ParameterizedTest
    @MethodSource("dictionaryParameters")
    void testGetDictionaryRandomWord(String difficulty, String category, List<String> expectedWords) {
        String word = Dictionary.getWord(difficulty.toLowerCase(), category.toLowerCase()).word.toUpperCase();

        assertThat(expectedWords).contains(word);
    }
}
