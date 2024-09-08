package backend.academy;

import java.io.InputStream;
import java.io.PrintStream;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static final InputStream IN = System.in;
    public static final PrintStream OUT = System.out;
    private final ViewOfTheGallows view = new ViewOfTheGallows(OUT);
    GallowsInput gallowsInput = new GallowsInput(IN, OUT);

    public static void main(String[] args) {
        view.helloMessage();
        GameLogic logic = new GameLogic(
            Dictionary.initializeWord(gallowsInput.getDifficulty(), gallowsInput.getCategory()),
            view,
            gallowsInput);
        logic.run();
    }
}
