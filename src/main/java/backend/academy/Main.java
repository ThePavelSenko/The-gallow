package backend.academy;

import lombok.experimental.UtilityClass;
import static backend.academy.Stream.OUT;
import static backend.academy.Stream.SCANNER;

@UtilityClass
public class Main {

    public static void main(String[] args) {
        ViewOfTheGallows view = new ViewOfTheGallows(OUT);
        GallowsInput gallowsInput = new GallowsInput();

        view.helloMessage();

        String difficulty = gallowsInput.getDifficulty(SCANNER);
        String category = gallowsInput.getCategory(SCANNER);
        Dictionary.initializeWords();
        WordData data = Dictionary.getWordData(difficulty, category);

        GameLogic logic = new GameLogic(data.word, data.description, view, gallowsInput);

        logic.run();
        SCANNER.close();
    }
}
