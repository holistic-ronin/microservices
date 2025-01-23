package bgr.matrixee.shuffle.domain;

import bgr.matrixee.logging.domain.LoggedRequest;
import bgr.matrixee.logging.infrastructure.LoggingClient;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShuffleFacade {

    private final ShuffleService shuffleService;
    private final LoggingClient loggingClient;

    @Value("${application.service-name}")
    private String serviceName;

    public int[] shuffleArray(final HttpServletRequest request, final int numbersToShuffleCount) {
        final var loggedRequest = new LoggedRequest(serviceName, request.getRequestURI(), String.valueOf(numbersToShuffleCount));
        loggingClient.logRequestAsync(loggedRequest);
        return shuffleService.shuffleArray(numbersToShuffleCount);
    }
}
