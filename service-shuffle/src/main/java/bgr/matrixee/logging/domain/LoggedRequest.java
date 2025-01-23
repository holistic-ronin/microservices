package bgr.matrixee.logging.domain;

import jakarta.servlet.http.HttpServletRequest;

public record LoggedRequest(HttpServletRequest request, String body) {}