import backend.academy.ViewOfTheGallows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ViewOfTheGallowsTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private ViewOfTheGallows view;

    @BeforeEach
    public void setUp() {
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        view = new ViewOfTheGallows();
    }

    @Test
    public void testDisplayWord() {
        String wordToGuess = "GIRAFFE";
        Set<Character> guessedLetters = Set.of('F', 'A', 'G');

        view.displayWord(wordToGuess, guessedLetters);

        String expectedOutput = "Word: G - - A F F -";

        assertThat(outContent.toString().trim()).isEqualTo(expectedOutput);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}
