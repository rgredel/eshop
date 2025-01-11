package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Mail;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.PhoneNumber;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Producer;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.ProducerId;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres.ProducerEntity;

@Component
public class ProducerEntityMapper {

    public ProducerEntity toEntity(Producer producer) {
        ProducerEntity producerEntity = new ProducerEntity();
        producerEntity.setId(producer.id().id());
        producerEntity.setName(producer.name());
        producerEntity.setMail(producer.mail().value());
        producerEntity.setPhoneNumber(producer.phoneNumber().value());
        return producerEntity;
    }

    public Producer toDomain(ProducerEntity producerEntity) {
        return new Producer(
            new ProducerId(producerEntity.getId()),
            producerEntity.getName(),
            new Mail(producerEntity.getMail()),
            new PhoneNumber(producerEntity.getPhoneNumber())
        );
    }
}