package gimeast.ch10_myapp2_api_server.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@Builder
public class PageRequestDTO {
    private int page; //1부터 시작
    private int size;

    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable() {
        return PageRequest.of((page - 1), size);
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of((page - 1), size, sort);
    }
}
