package bgr.matrixee.log.domain;

import org.springframework.stereotype.Component;

@Component
class ConsoleLogger implements Logger {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ConsoleLogger.class);

    @Override
    public void log(final String message) {
        logger.info(message);
    }
}
