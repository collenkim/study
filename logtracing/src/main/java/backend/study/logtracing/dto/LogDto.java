package backend.study.logtracing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LogDto {

    private String message;
    private String level;
    private String timestamp;
}
