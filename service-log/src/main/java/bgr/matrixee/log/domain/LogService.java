package bgr.matrixee.log.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final Logger logger;

    public void log(final String message) {
        logger.log(message);
    }
}
