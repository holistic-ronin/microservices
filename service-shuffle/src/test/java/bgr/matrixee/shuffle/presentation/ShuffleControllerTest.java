package bgr.matrixee.shuffle.presentation;

import bgr.matrixee.shuffle.domain.ShuffleFacade;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ShuffleControllerTest {

    private final ShuffleFacade facade = mock(ShuffleFacade.class);
    private final HttpServletRequest servletRequest = mock(HttpServletRequest.class);
    private final ShuffleController controller = new ShuffleController(facade);

    @Test
    void shouldReturnShuffledResponse() {
        //given:
        final var numberToShuffle = 5;
        final var requestBody = new ShuffleRequestBody(numberToShuffle);
        final var shuffledArray = new int[]{4, 2, 1, 5, 3};
        when(facade.shuffleArray(servletRequest, numberToShuffle)).thenReturn(shuffledArray);

        //when:
        final var response = controller.shuffleNumbers(requestBody, servletRequest);

        //then:
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("[4, 2, 1, 5, 3]");
    }
}
