package bgr.matrixee.log.presentation;

import bgr.matrixee.log.domain.LogService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LogControllerTest {

    private final LogService logService = mock(LogService.class);
    private final LogController controller = new LogController(logService);

    @Test
    void shouldLogRequest() {
        //given:
        final var request = new LogRequest(SERVICE_NAME, PATH, BODY);
        final var expectedLogMessage = String.format("Logging request: LogRequest(serviceName=%s, path=%s, body=%s)", SERVICE_NAME, PATH, BODY);

        //when:
        controller.logRequest(request);

        //then:
        verify(logService).log(expectedLogMessage);
    }

    private static final String SERVICE_NAME = "test-service";
    private static final String PATH = "/test-path";
    private static final String BODY = "test-body";
}
