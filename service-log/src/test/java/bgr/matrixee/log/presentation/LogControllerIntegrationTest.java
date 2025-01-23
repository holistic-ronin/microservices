package bgr.matrixee.log.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static bgr.matrixee.log.presentation.Paths.POST_LOG;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.profiles.active=integration-test")
class LogControllerIntegrationTest {

    @Value("${server.url}")
    private String serverUrl;

    @LocalServerPort
    private int serverPort;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void shouldLogRequestSuccessfully() {
        //given:
        final var url = UriComponentsBuilder.fromHttpUrl(serverUrl)
                .port(serverPort)
                .path(POST_LOG)
                .toUriString();

        final var request = new LogRequest(SERVICE_NAME, PATH, BODY);

        //when:
        final var response = restTemplate.postForEntity(url, request, Void.class);

        //then:
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }

    private static final String SERVICE_NAME = "test-service";
    private static final String PATH = "/test-path";
    private static final String BODY = "test-body";
}
