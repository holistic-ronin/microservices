package bgr.matrixee.shuffle.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ShuffleServiceTest {

    private final ShuffledArrayFactory factory = mock(ShuffledArrayFactory.class);
    private final ShuffleService service = new ShuffleService(factory);

    @Test
    void shouldDelegateArrayCreationToFactory() {
        //given:
        final var numberToShuffle = 5;
        final var shuffledArray = new int[]{4, 2, 1, 5, 3};
        when(factory.create(numberToShuffle)).thenReturn(shuffledArray);

        //when:
        final var result = service.createAndShuffleArray(numberToShuffle);

        //then:
        assertThat(result).isEqualTo(shuffledArray);
        verify(factory, times(1)).create(numberToShuffle);
    }
}
