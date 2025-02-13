package gimeast.ch09_myapp_api_server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BoardDto {
    private Long no;
    private String title;
    private String content;
    private String author;
    private LocalDate resdate;
    private int visited;
}
