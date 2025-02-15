package gimeast.ch10_myapp1_api_server.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductResponseDto {
    private Long pno;
    private String pname;
    private String cate;
    private String pcontent;
    private int hits;
    private LocalDateTime resdate;

    List<String> images = new ArrayList<>();
}
