package bgr.matrixee.logging.infrastructure;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Configuration
@RequiredArgsConstructor
public class LoggingWebClientConfiguration {

    @Value("${log-service.base-url}")
    private String baseUrl;

    @Getter
    @Value("${log-service.post-log}")
    private String postLogPath;

    @Bean
    public WebClient loggingWebClient() {
        return WebClient.builder()
                .baseUrl(this.baseUrl)
                .defaultHeaders(headers -> {
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                })
                .build();
    }
}
