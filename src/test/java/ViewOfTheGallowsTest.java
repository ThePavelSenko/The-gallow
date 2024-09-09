import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import backend.academy.ViewOfTheGallows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ViewOfTheGallowsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ViewOfTheGallows view;

    @BeforeEach
    public void setUpStreams() {
        PrintStream printStream = new PrintStream(outContent);
        view = new ViewOfTheGallows(printStream);
    }

    @ParameterizedTest
    @CsvSource({
        "PANDA, Word: P A - - A",
        "CAT, Word: C A -",
        "YELLOW, Word: - - - - - -",
        "CHICKEN, Word: C - - C - - -"
    })
    public void testDisplayWord(String word, String expected) {
        Set<Character> guessedLetters = Set.of('A', 'P', 'C');

        view.displayWord(word, guessedLetters);

        assertThat(outContent.toString()).isEqualTo(expected);
    }
}
