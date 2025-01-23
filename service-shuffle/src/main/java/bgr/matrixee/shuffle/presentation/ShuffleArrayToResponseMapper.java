package bgr.matrixee.shuffle.presentation;

import java.util.Arrays;

final class ShuffleArrayToResponseMapper {
    private ShuffleArrayToResponseMapper() {}

    public static ShuffleResponse mapToResponse(final int[] shuffledArray) {
        return new ShuffleResponse(
                Arrays.toString(shuffledArray)
        );
    }
}