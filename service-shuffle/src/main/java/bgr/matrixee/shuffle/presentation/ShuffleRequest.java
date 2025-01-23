package bgr.matrixee.shuffle.presentation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

record ShuffleRequest(
        @NotNull
        @Min(1)
        @Max(1000)
        Integer numbersToShuffleCount
) {}