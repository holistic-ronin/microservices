package bgr.matrixee.shuffle.presentation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShuffleArrayToResponseMapperTest {

    @Test
    void shouldMapShuffledArrayToResponse() {
        //given:
        final var shuffledArray = new int[]{4, 2, 1, 5, 3};

        //when:
        final var response = ShuffleArrayToResponseMapper.mapToResponse(shuffledArray);

        //then:
        assertThat(response.shuffledNumbers()).isEqualTo("[4, 2, 1, 5, 3]");
    }
}
