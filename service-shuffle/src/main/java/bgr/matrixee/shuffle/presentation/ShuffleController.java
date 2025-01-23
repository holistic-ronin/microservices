package bgr.matrixee.shuffle.presentation;

import bgr.matrixee.shuffle.domain.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShuffleController {

    private final ShuffleService shuffleService;

    @PostMapping
    @RequestMapping("/shuffle")
    ResponseEntity<String> shuffleNumbers(@Valid @RequestBody ShuffleRequest request) {
        return ResponseEntity.ok(
                ShuffleArrayToResponseMapper.mapToResponse(
                        shuffleService.createAndShuffleArray(request.numbersToShuffleCount()))
                        .shuffledNumbers()
        );
    }
}