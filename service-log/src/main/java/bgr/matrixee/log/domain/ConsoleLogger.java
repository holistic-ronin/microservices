package bgr.matrixee.log.domain;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class ConsoleLogger implements Logger {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConsoleLogger.class);

    @Override
    public void log(final String message) {
        logger.info(message);
    }
}
