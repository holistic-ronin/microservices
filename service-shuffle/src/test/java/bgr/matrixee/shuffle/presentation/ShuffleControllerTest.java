package bgr.matrixee.shuffle.presentation;

import bgr.matrixee.shuffle.domain.ShuffleService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShuffleControllerTest {

    private final ShuffleService service = mock(ShuffleService.class);
    private final ShuffleController controller = new ShuffleController(service);

    @Test
    void shouldReturnShuffledResponse() {
        //given:
        final var numberToShuffle = 5;
        final var request = new ShuffleRequest(numberToShuffle);
        final var shuffledArray = new int[]{4, 2, 1, 5, 3};
        when(service.createAndShuffleArray(numberToShuffle)).thenReturn(shuffledArray);

        //when:
        final var response = controller.shuffleNumbers(request);

        //then:
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("[4, 2, 1, 5, 3]");
    }
}
