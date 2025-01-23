package bgr.matrixee.shuffle.domain;

import bgr.matrixee.logging.domain.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Log4j2
@Service
@RequiredArgsConstructor
public class ShuffleFacade {

    private final ShuffleService shuffleService;
    private final LoggingService loggingService;

    public int[] shuffleArray(final HttpServletRequest request, final int numbersToShuffleCount) {
        log.info("Shuffling array with count: {}", numbersToShuffleCount);
        loggingService.logRequest(new LoggedRequest(request, String.valueOf(numbersToShuffleCount)));
        final var shuffledArray = shuffleService.shuffleArray(numbersToShuffleCount);
        log.debug("Shuffled array result: {}", Arrays.toString(shuffledArray));
        return shuffledArray;
    }

}
