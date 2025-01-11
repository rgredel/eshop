package pl.edu.pk.it.zsbd.eshop.product.application.producer;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.AddProducerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.ProducerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.mapper.ProducerMapper;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Producer;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.ProducerRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres.ProducerEntity;


import java.util.List;
import java.util.UUID;


@Service
public class ProducerService {
    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;

    public ProducerService(ProducerRepository producerRepository, ProducerMapper producerMapper) {
        this.producerRepository = producerRepository;
        this.producerMapper = producerMapper;
    }

    public List<ProducerDto> getAllProducers() {
        List<Producer> producers = producerRepository.findAll();
        return producers.stream().map(producerMapper::toProducerDto).toList();
    }

    public ProducerDto getProducersById(UUID id) {
        Producer producer = producerRepository.findById(id);
        return producerMapper.toProducerDto(producer);
    }

    public ProducerDto addProducer(AddProducerDto producerDto) {
        Producer producer = producerMapper.toProducer(producerDto);
        Producer save = producerRepository.save(producer);
        return producerMapper.toProducerDto(save);
    }

    public ProducerDto updateProducer(UUID id, ProducerDto producerDto) {
        Producer existingProducer = producerRepository.findById(id);
        if(existingProducer == null) {
            throw new ObjectNotFoundException(id, ProducerEntity.class.getName());
        }
        Producer updatedProducer = producerRepository.update(producerMapper.toProducer(producerDto));
        return producerMapper.toProducerDto(updatedProducer);
    }

    public void deleteProducer(UUID id) {
        producerRepository.delete(id);
    }
}