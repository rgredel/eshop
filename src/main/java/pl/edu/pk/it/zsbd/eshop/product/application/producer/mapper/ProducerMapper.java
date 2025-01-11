package pl.edu.pk.it.zsbd.eshop.product.application.producer.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.AddProducerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.ProducerDto;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Mail;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.PhoneNumber;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Producer;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.ProducerId;

@Component
public class ProducerMapper {

    public ProducerDto toProducerDto(Producer producer) {
        return new ProducerDto(
                producer.id().id(),
                producer.name(),
                producer.mail().value(),
                producer.phoneNumber().value()
        );
    }

    public Producer toProducer(ProducerDto producerDto) {
        return new Producer(
                new ProducerId(producerDto.id()),
                producerDto.name(),
                new Mail(producerDto.mail()),
                new PhoneNumber(producerDto.phoneNumber())
        );
    }

    public Producer toProducer(AddProducerDto producerDto) {
        return new Producer(
                new ProducerId(),
                producerDto.name(),
                new Mail(producerDto.mail()),
                new PhoneNumber(producerDto.phoneNumber())
        );
    }
}
