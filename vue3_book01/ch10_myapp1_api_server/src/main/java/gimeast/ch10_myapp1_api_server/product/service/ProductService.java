package gimeast.ch10_myapp1_api_server.product.service;

import gimeast.ch10_myapp1_api_server.product.common.utils.FileUtils;
import gimeast.ch10_myapp1_api_server.product.dto.ProductRequestDto;
import gimeast.ch10_myapp1_api_server.product.dto.ProductResponseDto;
import gimeast.ch10_myapp1_api_server.product.entity.Product;
import gimeast.ch10_myapp1_api_server.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {
    private final ProductRepository productRepository;

    @Value("${gimeast.upload.path}")
    private String UPLOAD_PATH;

    private final FileUtils fileUtils;

    private ProductResponseDto entityToDto(Product entity) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setPno(entity.getPno());
        dto.setPname(entity.getPname());
        dto.setCate(entity.getCate());
        dto.setPcontent(entity.getPcontent());
        dto.setHits(entity.getHits());
        dto.setResdate(entity.getResdate());
        return dto;
    }

    private Product dtoToEntity(ProductRequestDto dto, String img1Path, String img2Path, String img3Path) {
        return Product.builder()
                .pno(dto.getPno())
                .pname(dto.getPname())
                .cate(dto.getCate())
                .pcontent(dto.getPcontent())
                .hits(dto.getHits())
                .img1(img1Path)
                .img2(img2Path)
                .img3(img3Path)
                .build();
    }

    private List<ProductResponseDto> entityListToDtoList(List<Product> fetchedProducts) {
        List<ProductResponseDto> list = new ArrayList<>();
        for (Product product : fetchedProducts) {
            list.add(entityToDto(product));
        }

        return list;
    }

    public List<ProductResponseDto> getProducts() {
        List<Product> fetchedProducts = productRepository.findAll();
        return entityListToDtoList(fetchedProducts);
    }

    public boolean saveProduct(ProductRequestDto productRequestDto) {
        // 파일 저장 후 경로 반환
        String img1Path = fileUtils.uploadFile(productRequestDto.getImg1());
        String img2Path = fileUtils.uploadFile(productRequestDto.getImg2());
        String img3Path = fileUtils.uploadFile(productRequestDto.getImg3());

        Product save = productRepository.save(dtoToEntity(productRequestDto, img1Path, img2Path, img3Path));
        return save.getPno() != null && save.getPno() != 0;
    }

    public ProductResponseDto getProduct(Long pno) {
        Optional<Product> findProduct = productRepository.findById(pno);
        Product product = findProduct.orElseThrow();

        List<String> images = new ArrayList<>();
        images.add(ObjectUtils.isEmpty(product.getImg1()) ? null : "product/" + product.getImg1());
        images.add(ObjectUtils.isEmpty(product.getImg2()) ? null : "product/" + product.getImg2());
        images.add(ObjectUtils.isEmpty(product.getImg3()) ? null : "product/" + product.getImg3());

        ProductResponseDto productResponseDto = entityToDto(product);
        productResponseDto.setImages(images);

        return productResponseDto;
    }

    @Transactional
    public boolean updateProduct(Long pno, ProductRequestDto productRequestDto) {
        log.info("productRequestDto: {}", productRequestDto);

        Optional<Product> findProduct = productRepository.findById(pno);
        if(findProduct.isPresent()) {
            Product product = findProduct.get();
            deleteImages(product);

            String img1Path = fileUtils.uploadFile(productRequestDto.getImg1());
            String img2Path = fileUtils.uploadFile(productRequestDto.getImg2());
            String img3Path = fileUtils.uploadFile(productRequestDto.getImg3());

            product.updateProduct(productRequestDto.getPname(), productRequestDto.getPcontent(), img1Path, img2Path, img3Path);

            return true;
        }

        return false;
    }

    public boolean deleteProduct(Long pno) {
        Optional<Product> findProduct = productRepository.findById(pno);

        if(findProduct.isPresent()) {
            Product product = findProduct.get();
            productRepository.delete(product);
            deleteImages(product);

            return true;
        }

        return false;
    }

    private void deleteImages(Product product) {
        if(!ObjectUtils.isEmpty(product.getImg1()))
            fileUtils.deleteFiles(product.getImg1());

        if(!ObjectUtils.isEmpty(product.getImg2()))
            fileUtils.deleteFiles(product.getImg2());

        if(!ObjectUtils.isEmpty(product.getImg3()))
            fileUtils.deleteFiles(product.getImg3());
    }

}
