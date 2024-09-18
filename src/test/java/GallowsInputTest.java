import backend.academy.GallowsInput;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;

public class GallowsInputTest {

    @Test
    public void testPlayerInputValidLetter() {
        String input = "a\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        GallowsInput gallowsInput = new GallowsInput();
        char result = gallowsInput.playerInputLetter(scanner);

        Assertions.assertEquals('A', result);
        scanner.close();
    }

    @Test
    public void testPlayerInputInvalidThenValidLetter() {
        String input = "1\nb\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        GallowsInput gallowsInput = new GallowsInput();
        char result = gallowsInput.playerInputLetter(scanner);

        Assertions.assertEquals('B', result);
        scanner.close();
    }
}
