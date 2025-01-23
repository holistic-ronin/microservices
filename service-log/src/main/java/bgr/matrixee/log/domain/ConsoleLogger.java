package bgr.matrixee.log.domain;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
class ConsoleLogger implements Logger {

    @Override
    public void log(final String message) {
        log.info(message);
    }
}
