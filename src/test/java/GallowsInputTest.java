import backend.academy.GallowsInput;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;

public class GallowsInputTest {

    @Test
    public void testPlayerInputValidLetter() {
        String input = "a\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GallowsInput gallowsInput = new GallowsInput();
        char result = gallowsInput.playerInputLetter();

        Assertions.assertEquals('A', result);
    }

    @Test
    public void testPlayerInputInvalidThenValidLetter() {
        String input = "1\nb\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GallowsInput gallowsInput = new GallowsInput();
        char result = gallowsInput.playerInputLetter();

        Assertions.assertEquals('B', result);
    }
}
