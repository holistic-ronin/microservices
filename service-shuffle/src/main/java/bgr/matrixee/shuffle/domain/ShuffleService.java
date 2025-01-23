package bgr.matrixee.shuffle.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShuffleService {

    private final ShuffledArrayFactory shuffledArrayFactory;

    public int[] createAndShuffleArray(int numbersToShuffleCount) {
        return shuffledArrayFactory.create(numbersToShuffleCount);
    }
}
