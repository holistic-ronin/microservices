package bgr.matrixee.logging.infrastructure;

import bgr.matrixee.logging.domain.LoggedRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Log4j2
@RequiredArgsConstructor
public class LoggingClient {
    private final WebClient loggingWebClient;
    private final LoggingWebClientConfiguration configuration;

    public void logRequest(final LoggedRequest loggedRequest) {
        sendLoggedRequest(loggingWebClient, loggedRequest);
    }

    private void sendLoggedRequest(final WebClient client, final LoggedRequest loggedRequest) {
        client.post()
                .uri(configuration.getPostLogPath())
                .bodyValue(loggedRequest)
                .retrieve()
                .onStatus(HttpStatusCode::isError, response ->
                        response.bodyToMono(String.class)
                                .doOnNext(body -> log.warn(
                                        "Logging failed via service-log: Status: {}, Response body: {}, Request body: {}, Path: {}",
                                        response.statusCode(),
                                        body,
                                        loggedRequest.body(),
                                        loggedRequest.uri()
                                ))
                                .then(Mono.empty())
                )
                .toBodilessEntity()
                .block();
    }
}
