package gimeast.ch10_myapp2_api_server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DataroomReqDto {
    private Long dno;
    private String title;
    private String content;
    private String author;
    private MultipartFile datafile;
    private int hits;
    private LocalDateTime regdate;
    private LocalDateTime modDate;
}
