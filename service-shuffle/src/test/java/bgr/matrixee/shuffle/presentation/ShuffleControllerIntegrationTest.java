package bgr.matrixee.shuffle.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static bgr.matrixee.shuffle.presentation.Paths.POST_SHUFFLE;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@AutoConfigureWireMock
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "spring.profiles.active=integration-test")
class ShuffleControllerIntegrationTest {

    @Value("${server.url}")
    private String serverUrl;

    @Value("${log-service.post-log}")
    private String postLogPath;

    @LocalServerPort
    private int serverPort;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void shouldRespondQuicklyWhileLoggingAsynchronously_FailureDemo() throws InterruptedException {
        //given:
        final var delayInMilliseconds = 5000;
        stubFor(post(urlPathEqualTo(postLogPath))
                .willReturn(aResponse()
                        .withFixedDelay(delayInMilliseconds)
                        .withStatus(200)
                        .withBody("{}")));

        final var url = UriComponentsBuilder.fromHttpUrl(serverUrl)
                .port(serverPort)
                .path(POST_SHUFFLE)
                .toUriString();

        final var request = new ShuffleRequestBody(5);

        //when:
        final var startTime = Instant.now();
        final var response = restTemplate.postForObject(url, request, String.class);
        final var endTime = Instant.now();

        //then:
        final var duration = endTime.toEpochMilli() - startTime.toEpochMilli();
        assertThat(duration).isLessThan(delayInMilliseconds);

        assertThat(response).isNotBlank();
        assertThat(response).contains("[");
        final var responseArray = parseResponseArray(response);

        assertThat(responseArray).hasSize(5);
        assertThat(responseArray).containsExactlyInAnyOrder(1, 2, 3, 4, 5);

        await().atMost(6, TimeUnit.SECONDS).untilAsserted(() ->
                verify(postRequestedFor(urlPathEqualTo(postLogPath))));
    }

    private int[] parseResponseArray(final String response) {
        return Arrays.stream(response.replaceAll("[\\[\\]]", "").split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
