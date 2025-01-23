package bgr.matrixee.shuffle.presentation;

import bgr.matrixee.shuffle.domain.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static bgr.matrixee.shuffle.presentation.Paths.API;
import static bgr.matrixee.shuffle.presentation.Paths.SHUFFLE;

@Log4j2
@RestController
@RequestMapping(API)
@RequiredArgsConstructor
public class ShuffleController {

    private final ShuffleFacade shuffleFacade;

    @PostMapping(SHUFFLE)
    ResponseEntity<String> shuffleNumbers(@Valid @RequestBody final ShuffleRequestBody body,
                                          final HttpServletRequest request) {
        log.info("Received shuffle request with count: {}", body.numbersToShuffleCount());
        final var response = ShuffleArrayToResponseMapper.mapToResponse(
                shuffleFacade.shuffleArray(request, body.numbersToShuffleCount())).shuffledNumbers();
        log.debug("Generated shuffled numbers: {}", response);
        return ResponseEntity.ok(response);
    }
}