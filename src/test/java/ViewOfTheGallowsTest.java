import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import backend.academy.ViewOfTheGallows;

class ViewOfTheGallowsTest {

    @ParameterizedTest
    @CsvSource({
        "PANDA, P A - - A",
        "CAT, C A -",
        "YELLOW, - - - - - -",
        "CHICKEN, C - - C - - -"
    })
    void testDisplayWord(String wordToGuess, String expectedOutput) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        ViewOfTheGallows viewOfTheGallows = new ViewOfTheGallows(printStream);

        Set<Character> guessedLetters = Set.of('A', 'P', 'C');

        viewOfTheGallows.displayWord(wordToGuess, guessedLetters);

        assertThat(outputStream.toString().trim()).isEqualTo("Word: " + expectedOutput);
    }
}
