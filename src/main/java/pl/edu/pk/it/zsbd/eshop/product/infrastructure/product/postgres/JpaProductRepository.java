package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Product;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres.mapper.ProductEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaProductRepository {
    private final ProductEntityRepository productEntityRepository;
    private final ProductEntityMapper productEntityMapper;

    public JpaProductRepository(ProductEntityRepository productEntityRepository, ProductEntityMapper productEntityMapper) {
        this.productEntityRepository = productEntityRepository;
        this.productEntityMapper = productEntityMapper;
    }

    public Product save(Product product) {
        ProductEntity productEntity = productEntityMapper.toEntity(product);
        productEntityRepository.save(productEntity);
        return product;
    }

    public Product update(Product product) {
        ProductEntity productEntity = productEntityMapper.toEntity(product);
        productEntityRepository.save(productEntity);
        return product;
    }

    public Product findById(UUID id) {
        Optional<ProductEntity> byId = productEntityRepository.findById(id);
        ProductEntity productEntity = byId.orElseThrow();
        return productEntityMapper.toDomain(productEntity);
    }

    public void delete(UUID id) {
        Optional<ProductEntity> productEntity = productEntityRepository.findById(id);
        productEntity.ifPresent(productEntityRepository::delete);
    }

    public List<Product> findAll() {
        List<ProductEntity> productEntities = productEntityRepository.findAll();
        return productEntities.stream().map(productEntityMapper::toDomain).toList();
    }
}
