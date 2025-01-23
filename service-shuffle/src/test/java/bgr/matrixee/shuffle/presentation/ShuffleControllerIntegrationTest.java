package bgr.matrixee.shuffle.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

import static bgr.matrixee.shuffle.presentation.Paths.POST_SHUFFLE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.profiles.active=integration-test")
class ShuffleControllerIntegrationTest {

    @Value("${server.url}")
    private String serverUrl;

    @LocalServerPort
    private int serverPort;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void shouldCallShuffleEndpoint() {
        //given:
        final var url = UriComponentsBuilder.fromHttpUrl(serverUrl)
                .port(serverPort)
                .path(POST_SHUFFLE)
                .toUriString();

        final var request = new ShuffleRequestBody(5);

        //when:
        final var response = restTemplate.postForObject(url, request, String.class);

        //then:
        assertThat(response).isNotBlank();
        assertThat(response).contains("[");
        final var responseArray = parseResponseArray(response);

        assertThat(responseArray).hasSize(5);
        assertThat(responseArray).containsExactlyInAnyOrder(1, 2, 3, 4, 5);
    }

    private int[] parseResponseArray(final String response) {
        return Arrays.stream(response.replaceAll("[\\[\\]]", "").split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
