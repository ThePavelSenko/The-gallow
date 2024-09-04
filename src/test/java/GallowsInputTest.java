import backend.academy.GallowsInput;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;

public class GallowsInputTest {
    @Test
    public void testPlayerInputValidLetter() {
        String input = "a\n";  // The input that will be simulated
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GallowsInput gallowsInput = new GallowsInput();
        char result = gallowsInput.playerInputLetter();

        Assertions.assertEquals('a', result);
    }

    @Test
    public void testPlayerInputInvalidThenValidLetter() {
        // Input with an error, then correct input
        String input = "1\nb\n";  // The input that will be simulated
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GallowsInput gallowsInput = new GallowsInput();
        char result = gallowsInput.playerInputLetter();

        Assertions.assertEquals('b', result);
    }


}
