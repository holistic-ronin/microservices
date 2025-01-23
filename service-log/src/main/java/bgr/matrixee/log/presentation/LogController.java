package bgr.matrixee.log.presentation;

import bgr.matrixee.log.domain.LogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static bgr.matrixee.log.presentation.Paths.API;
import static bgr.matrixee.log.presentation.Paths.LOG;

@RestController
@RequestMapping(API)
@RequiredArgsConstructor
class LogController {
    private final LogService logService;

    @PostMapping
    @RequestMapping(LOG)
    void logRequest(@Valid @RequestBody final LogRequest request) {
        logService.log(String.format("Logging request: %s", request.toString()));
    }
}
