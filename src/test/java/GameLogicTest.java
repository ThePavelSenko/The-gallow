import backend.academy.GallowsInput;
import backend.academy.GameLogic;
import backend.academy.ViewOfTheGallows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class GameLogicTest {

    private GameLogic logic;
    private ViewOfTheGallows mockView;
    private GallowsInput mockInput;

    @BeforeEach
    public void setUp() {
        mockInput = mock(GallowsInput.class);
        mockView = mock(ViewOfTheGallows.class);
        logic = new GameLogic("cat", mockView, mockInput);
    }

    @Test
    public void testPlayWin() {
        Mockito.when(mockInput.playerInputLetter()).thenReturn('c', 'a', 't');

        logic.play();

        verify(mockView, times(4)).displayWord(anyString(), anySet()); // 1) Initial display, 2) After 'c', 3) After 'a', 4) After 't'
        verify(mockInput).printMessage("You have won!");
    }

    @Test
    public void testPlayLose() {
        Mockito.when(mockInput.playerInputLetter()).thenReturn('x', 'y', 'z', 'u', 'v', 'w');

        logic.play();

        // Verify that displayGallows was called exactly once with MAX_ATTEMPTS
        verify(mockView).displayGallows(GameLogic.MAX_ATTEMPTS());
        // Verify that the losing message was printed
        verify(mockInput).printMessage("You have lost! Secret word was: cat");
    }

}
