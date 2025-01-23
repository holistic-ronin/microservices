package bgr.matrixee.log.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogServiceTest {

    private final Logger logger = Mockito.mock(Logger.class);
    private final LogService logService = new LogService(logger);

    @Test
    void shouldLogMessage() {
        //given:
        final var message = "Test log message";

        //when:
        logService.log(message);

        //then:
        Mockito.verify(logger).log(message);
    }
}
