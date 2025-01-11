package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderDocumentRepository extends MongoRepository<OrderDocument, UUID> {
}