package bgr.matrixee.log.presentation;

import bgr.matrixee.log.domain.LogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import static bgr.matrixee.log.presentation.Paths.API;
import static bgr.matrixee.log.presentation.Paths.LOG;

@Log4j2
@RestController
@RequestMapping(API)
@RequiredArgsConstructor
class LogController {
    private final LogService logService;

    @PostMapping(LOG)
    void logRequest(@Valid @RequestBody final LogRequest request) {
        log.info("Received log request : {}", request.toString());
        logService.log(String.format("Logging request: %s", request));
    }
}
