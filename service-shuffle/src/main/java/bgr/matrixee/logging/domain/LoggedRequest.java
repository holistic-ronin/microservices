package bgr.matrixee.logging.domain;

import jakarta.servlet.http.HttpServletRequest;

public record LoggedRequest(String serviceName, String path, String body) {
    public LoggedRequest(final String serviceName, final HttpServletRequest request, final String body) {
        this(serviceName, request.getRequestURI(), body);
    }
}
