package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductDocumentRepository extends MongoRepository<ProductDocument, UUID> {
}