package gimeast.ch10_myapp2_api_server.repository;

import gimeast.ch10_myapp2_api_server.entity.Dataroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataroomRepository extends JpaRepository<Dataroom, Long> {

}
