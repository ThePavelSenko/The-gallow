package backend.academy;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {

    public static void main(String[] args) {
        ViewOfTheGallows view = new ViewOfTheGallows();
        GallowsInput gallowsInput = new GallowsInput();

        view.helloMessage();

        GameLogic logic = new GameLogic(
            Dictionary.getWord(gallowsInput.getDifficulty(), gallowsInput.getCategory()).word,
            view,
            gallowsInput);

        logic.run();
    }
}
