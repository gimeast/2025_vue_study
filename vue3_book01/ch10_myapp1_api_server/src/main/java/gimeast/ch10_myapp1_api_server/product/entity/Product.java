package gimeast.ch10_myapp1_api_server.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;
    private String cate;
    private String pname;
    private String pcontent;
    private String img1;
    private String img2;
    private String img3;
    private LocalDateTime resdate;
    private int hits;

    public void updateProduct(String pname, String pcontent, String img1Path, String img2Path, String img3Path) {
        this.pname = pname;
        this.pcontent = pcontent;
        this.img1 = img1Path;
        this.img2 = img2Path;
        this.img3 = img3Path;
    }
}
