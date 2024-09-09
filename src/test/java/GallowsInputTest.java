import backend.academy.GallowsInput;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import static java.lang.System.out;

public class GallowsInputTest {

    @Test
    public void testPlayerInputValidLetter() {
        String input = "a\n";  // The input that will be simulated
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GallowsInput gallowsInput = new GallowsInput(in, out);
        char result = gallowsInput.playerInputLetter();

        Assertions.assertEquals('A', result);
    }

    @Test
    public void testPlayerInputInvalidThenValidLetter() {
        // Input with an error, then correct input
        String input = "1\nb\n";  // The input that will be simulated
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GallowsInput gallowsInput = new GallowsInput(in, out);
        char result = gallowsInput.playerInputLetter();

        Assertions.assertEquals('B', result);
    }
}
