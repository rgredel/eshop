package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Producer;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres.mapper.ProducerEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaProducerRepository{
    private final ProducerEntityRepository producerEntityRepository;
    private final ProducerEntityMapper producerEntityMapper;

    public JpaProducerRepository(ProducerEntityRepository producerEntityRepository, ProducerEntityMapper producerEntityMapper) {
        this.producerEntityRepository = producerEntityRepository;
        this.producerEntityMapper = producerEntityMapper;
    }

    public Producer save(Producer producer) {
        ProducerEntity producerEntity = producerEntityMapper.toEntity(producer);
        producerEntityRepository.save(producerEntity);
        return producer;
    }

    public Producer update(Producer producer) {
        ProducerEntity productEntity = producerEntityMapper.toEntity(producer);
        producerEntityRepository.save(productEntity);
        return producer;
    }

    public Producer findById(UUID id) {
        Optional<ProducerEntity> byId = producerEntityRepository.findById(id);
        ProducerEntity producerEntity = byId.orElseThrow();
        return producerEntityMapper.toDomain(producerEntity);
    }

    public void delete(UUID id) {
        Optional<ProducerEntity> producerEntity = producerEntityRepository.findById(id);
        producerEntity.ifPresent(producerEntityRepository::delete);
    }

    public List<Producer> findAll() {
        List<ProducerEntity> producerEntities = producerEntityRepository.findAll();
        return producerEntities.stream().map(producerEntityMapper::toDomain).toList();
    }
}
