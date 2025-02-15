package gimeast.ch10_myapp1_api_server.product.controller;

import gimeast.ch10_myapp1_api_server.product.dto.ProductRequestDto;
import gimeast.ch10_myapp1_api_server.product.dto.ProductResponseDto;
import gimeast.ch10_myapp1_api_server.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:8080"})
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products/list")
    public ResponseEntity<List<ProductResponseDto>> getProducts() {
        List<ProductResponseDto> products = productService.getProducts();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/products/insert")
    public ResponseEntity<Object> saveProduct(ProductRequestDto productRequestDto) {
        boolean isSuccess = productService.saveProduct(productRequestDto);

        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/products/detail/{pno}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long pno) {
        ProductResponseDto product = productService.getProduct(pno);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/products/update/{pno}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long pno, ProductRequestDto  productRequestDto) {
        boolean isSuccess = productService.updateProduct(pno, productRequestDto);

        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/products/delete/{pno}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long pno) {
        boolean isSuccess = productService.deleteProduct(pno);

        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
