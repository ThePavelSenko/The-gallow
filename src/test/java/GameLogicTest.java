import backend.academy.GallowsInput;
import backend.academy.GameLogic;
import backend.academy.ViewOfTheGallows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        when(mockInput.getMaxAttempts()).thenReturn(GameLogic.MAX_ATTEMPTS); // Устанавливаем количество попыток
        logic = new GameLogic("cat", mockView, mockInput);
    }

    @Test
    public void testPlayWin() {
        // We ask the right answers to win
        Mockito.when(mockInput.playerInputLetter()).thenReturn('c', 'a', 't');

        logic.play();

        verify(mockView, times(4)).displayWord(anyString(), anySet());

        verify(mockView, times(3)).displayAttemptsLeft(anyInt());

        verify(mockView, times(3)).displayGallows(anyInt());

        verify(mockInput).printMessage("You have won!");
    }

    @Test
    public void testPlayLose() {
        // Asking the wrong answers to lose
        Mockito.when(mockInput.playerInputLetter()).thenReturn('x', 'y', 'z', 'u', 'v', 'w');

        logic.play();


        verify(mockView, times(6)).displayWord(anyString(), anySet());

        verify(mockView, times(6)).displayAttemptsLeft(anyInt());

        verify(mockView, times(7)).displayGallows(anyInt());

        verify(mockInput).printMessage("You have lost! Secret word was: cat");
    }
}
