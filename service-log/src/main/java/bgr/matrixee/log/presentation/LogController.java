package bgr.matrixee.log.presentation;

import bgr.matrixee.log.domain.LogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
class LogController {
    private final LogService logService;

    @PostMapping
    void logRequest(@Valid @RequestBody final LogRequest request) {
        logService.log(String.format("Logging request: %s", request.toString()));
    }
}
