package bgr.matrixee.logging.domain;

import jakarta.servlet.http.HttpServletRequest;

public record LoggedRequest(String uri, String method, String body) {
    public LoggedRequest(final HttpServletRequest request, final String body) {
        this(request.getRequestURI(), request.getMethod(), body);
    }
}
