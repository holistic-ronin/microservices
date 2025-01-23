package bgr.matrixee.shuffle.domain;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.*;

@Component
final class ShuffledArrayFactory {
    int[] create(final int numberToShuffle) {
        final var list = IntStream.rangeClosed(1, numberToShuffle)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
