package backend.academy;

import lombok.experimental.UtilityClass;
import static backend.academy.Stream.OUT;

@UtilityClass
public class Main {

    public static void main(String[] args) {
        ViewOfTheGallows view = new ViewOfTheGallows(OUT);
        GallowsInput gallowsInput = new GallowsInput();

        view.helloMessage();

        GameLogic logic = new GameLogic(
            Dictionary.getWord(gallowsInput.getDifficulty(), gallowsInput.getCategory()).word,
            view,
            gallowsInput);

        logic.run();
    }
}
