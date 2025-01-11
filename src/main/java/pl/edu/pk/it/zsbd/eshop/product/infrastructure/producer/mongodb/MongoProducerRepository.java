package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Producer;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb.mapper.ProducerDocumentMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MongoProducerRepository{
    private final ProducerDocumentRepository producerDocumentRepository;
    private final ProducerDocumentMapper producerDocumentMapper;

    public MongoProducerRepository(ProducerDocumentRepository producerDocumentRepository, ProducerDocumentMapper producerDocumentMapper) {
        this.producerDocumentRepository = producerDocumentRepository;
        this.producerDocumentMapper = producerDocumentMapper;
    }

    public Producer save(Producer producer) {
        ProducerDocument document = producerDocumentMapper.toDocument(producer);
        producerDocumentRepository.save(document);
        return producer;
    }

    public Producer update(Producer producer) {
        ProducerDocument productEntity = producerDocumentMapper.toDocument(producer);
        producerDocumentRepository.save(productEntity);
        return producer;
    }

    public Producer findById(UUID id) {
        Optional<ProducerDocument> byId = producerDocumentRepository.findById(id);
        ProducerDocument producerEntity = byId.orElseThrow();
        return producerDocumentMapper.toDomain(producerEntity);
    }

    public void delete(UUID id) {
        Optional<ProducerDocument> byId = producerDocumentRepository.findById(id);
        byId.ifPresent(producerDocumentRepository::delete);
    }

    public List<Producer> findAll() {
        List<ProducerDocument> all = producerDocumentRepository.findAll();
        return all.stream().map(producerDocumentMapper::toDomain).toList();
    }
}
