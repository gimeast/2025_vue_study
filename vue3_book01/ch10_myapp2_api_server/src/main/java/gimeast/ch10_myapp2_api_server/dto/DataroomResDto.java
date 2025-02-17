package gimeast.ch10_myapp2_api_server.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DataroomResDto {
    private Long dno;
    private String title;
    private String content;
    private String author;
    private int hits;
    private LocalDateTime regdate;
    private String datafile;
    private String datafileName;
}
