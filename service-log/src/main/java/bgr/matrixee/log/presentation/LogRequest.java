package bgr.matrixee.log.presentation;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class LogRequest {
    @NotBlank
    private String serviceName;
    @NotBlank
    private String path;
    @NotBlank
    private String body;
}
