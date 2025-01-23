package bgr.matrixee.log.presentation;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
class LogRequest {
    @NotBlank
    private String serviceName;
    @NotBlank
    private String path;
    @NotBlank
    private String body;
}
