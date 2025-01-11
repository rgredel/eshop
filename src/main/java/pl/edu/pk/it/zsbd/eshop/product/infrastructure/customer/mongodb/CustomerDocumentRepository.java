package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerDocumentRepository extends MongoRepository<CustomerDocument, UUID> {
}