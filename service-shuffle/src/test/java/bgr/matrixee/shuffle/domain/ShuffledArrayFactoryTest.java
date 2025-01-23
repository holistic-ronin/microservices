package bgr.matrixee.shuffle.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShuffledArrayFactoryTest {

    private final ShuffledArrayFactory factory = new ShuffledArrayFactory();

    @Test
    void shouldCreateShuffledArray() {
        //given:
        final var numberToShuffle = 5;

        //when:
        final var result = factory.create(numberToShuffle);

        //then:
        assertThat(result).hasSize(numberToShuffle);
        assertThat(result).containsExactlyInAnyOrder(1, 2, 3, 4, 5);
    }
}
