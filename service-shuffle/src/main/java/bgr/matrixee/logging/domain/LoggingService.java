package bgr.matrixee.logging.domain;

import bgr.matrixee.logging.infrastructure.LoggingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggingService {
    private final LoggingClient loggingClient;

    public void logRequest(final LoggedRequest request) {
        loggingClient.logRequestAsync(request);
    }
}
