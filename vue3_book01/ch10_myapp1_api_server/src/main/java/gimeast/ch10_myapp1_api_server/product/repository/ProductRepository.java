package gimeast.ch10_myapp1_api_server.product.repository;

import gimeast.ch10_myapp1_api_server.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteProductByPno(Long pno);
}
