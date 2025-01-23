package bgr.matrixee.shuffle.domain;

import bgr.matrixee.logging.domain.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShuffleFacade {

    private final ShuffleService shuffleService;
    private final LoggingService loggingService;

    @Value("${application.service-name}")
    private String serviceName;

    public int[] shuffleArray(final HttpServletRequest request, final int numbersToShuffleCount) {
        loggingService.logRequest(new LoggedRequest(serviceName, request, String.valueOf(numbersToShuffleCount)));
        return shuffleService.shuffleArray(numbersToShuffleCount);
    }
}
