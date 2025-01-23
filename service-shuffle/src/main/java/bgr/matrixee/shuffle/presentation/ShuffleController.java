package bgr.matrixee.shuffle.presentation;

import bgr.matrixee.shuffle.domain.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static bgr.matrixee.shuffle.presentation.Paths.API;
import static bgr.matrixee.shuffle.presentation.Paths.SHUFFLE;

@RestController
@RequestMapping(API)
@RequiredArgsConstructor
public class ShuffleController {

    private final ShuffleService shuffleService;

    @PostMapping
    @RequestMapping(SHUFFLE)
    ResponseEntity<String> shuffleNumbers(@Valid @RequestBody ShuffleRequest request) {
        return ResponseEntity.ok(
                ShuffleArrayToResponseMapper.mapToResponse(
                        shuffleService.createAndShuffleArray(request.numbersToShuffleCount()))
                        .shuffledNumbers()
        );
    }
}