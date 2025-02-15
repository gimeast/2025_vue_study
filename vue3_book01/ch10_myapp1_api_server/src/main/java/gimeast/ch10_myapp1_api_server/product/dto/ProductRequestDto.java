package gimeast.ch10_myapp1_api_server.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductRequestDto {
    private Long pno;
    private String cate;
    private String pname;
    private String pcontent;
    private MultipartFile img1;
    private MultipartFile img2;
    private MultipartFile img3;
    private LocalDateTime resdate;
    private int hits;
}
