package gimeast.ch10_myapp2_api_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Dataroom extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dno;
    private String title;
    private String content;
    private String author;
    private String datafile;
    @ColumnDefault("0")
    private int hits;

    public void updateDataroom(String title, String content, String author, String datafile) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.datafile = datafile;
    }
}
