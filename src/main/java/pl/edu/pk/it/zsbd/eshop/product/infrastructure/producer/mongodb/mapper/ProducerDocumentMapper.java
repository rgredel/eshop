package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Mail;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.PhoneNumber;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Producer;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.ProducerId;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb.ProducerDocument;

@Component
public class ProducerDocumentMapper {

    public ProducerDocument toDocument(Producer producer) {
        ProducerDocument producerDocument = new ProducerDocument();
        producerDocument.setId(producer.id().id());
        producerDocument.setName(producer.name());
        producerDocument.setMail(producer.mail().value());
        producerDocument.setPhoneNumber(producer.phoneNumber().value());
        return producerDocument;
    }

    public Producer toDomain(ProducerDocument producerDocument) {
        return new Producer(
            new ProducerId(producerDocument.getId()),
            producerDocument.getName(),
            new Mail(producerDocument.getMail()),
            new PhoneNumber(producerDocument.getPhoneNumber())
        );
    }
}