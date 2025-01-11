package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Product;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb.mapper.ProductDocumentMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MongoProductRepository {
    private final ProductDocumentRepository productDocumentRepository;
    private final ProductDocumentMapper productDocumentMapper;

    public MongoProductRepository(ProductDocumentRepository productDocumentRepository, ProductDocumentMapper productDocumentMapper) {
        this.productDocumentRepository = productDocumentRepository;
        this.productDocumentMapper = productDocumentMapper;
    }

    public Product save(Product product) {
        ProductDocument document = productDocumentMapper.toDocument(product);
        productDocumentRepository.save(document);
        return product;
    }

    public Product update(Product product) {
        ProductDocument document = productDocumentMapper.toDocument(product);
        productDocumentRepository.save(document);
        return product;
    }

    public Product findById(UUID id) {
        Optional<ProductDocument> byId = productDocumentRepository.findById(id);
        ProductDocument productDocument = byId.orElseThrow();
        return productDocumentMapper.toDomain(productDocument);
    }

    public void delete(UUID id) {
        Optional<ProductDocument> byId = productDocumentRepository.findById(id);
        byId.ifPresent(productDocumentRepository::delete);
    }

    public List<Product> findAll() {
        List<ProductDocument> all = productDocumentRepository.findAll();
        return all.stream().map(productDocumentMapper::toDomain).toList();
    }
}
