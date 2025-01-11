package pl.edu.pk.it.zsbd.eshop.product.application.producer.dto;

import java.util.UUID;

public record ProducerDto(UUID id, String name, String mail, Long phoneNumber) {
}
