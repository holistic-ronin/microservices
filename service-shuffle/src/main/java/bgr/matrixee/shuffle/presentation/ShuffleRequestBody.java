package bgr.matrixee.shuffle.presentation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

record ShuffleRequestBody(
        @NotNull(message = "The numbersToShuffleCount field must not be null.")
        @Min(value = 1, message = "The numbersToShuffleCount field must be at least 1.")
        @Max(value = 1000, message = "The numbersToShuffleCount field must not exceed 1000.")
        Integer numbersToShuffleCount
) {}
