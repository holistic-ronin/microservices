package bgr.matrixee.logging.domain;

import org.springframework.http.HttpRequest;

public record LoggedRequest(HttpRequest request, String body) {}