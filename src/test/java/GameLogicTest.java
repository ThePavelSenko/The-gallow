import backend.academy.GameLogic;
import backend.academy.GallowsInput;
import backend.academy.ViewOfTheGallows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyInt;
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
        when(mockInput.getMaxAttempts(any())).thenReturn(GameLogic.MAX_DEFAULT_ATTEMPTS);
        logic = new GameLogic("cat", "A small domesticated carnivorous mammal", mockView, mockInput);
    }

    @Test
    public void testPlayWin() {
        // Mock user input to win the game
        when(mockInput.playerInputLetter(any())).thenReturn('c', 'a', 't');

        logic.play();

        // Verify interactions with the mock
        verify(mockView, times(4)).displayWord(anyString(), anySet());
        verify(mockView, times(3)).displayAttemptsLeft(anyInt());
        verify(mockView, times(3)).displayGallows(anyInt());
        verify(mockInput).printMessage("\nYou have won!");
    }

    @Test
    public void testPlayLose() {
        // Mock user input to lose the game
        when(mockInput.playerInputLetter(any())).thenReturn('x', 'y', 'a', 's', 'z', 'c', 'w');

        logic.play();

        // Verify interactions with the mock
        verify(mockView, times(8)).displayWord(anyString(), anySet());
        verify(mockView, times(8)).displayAttemptsLeft(anyInt());
        verify(mockView, times(9)).displayGallows(anyInt());
        verify(mockInput).printMessage("You have lost! Secret word was: cat");
    }
}
