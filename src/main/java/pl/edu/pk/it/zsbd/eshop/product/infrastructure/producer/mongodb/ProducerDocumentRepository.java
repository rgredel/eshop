package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProducerDocumentRepository extends MongoRepository<ProducerDocument, UUID> {
}