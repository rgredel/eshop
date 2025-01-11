package pl.edu.pk.it.zsbd.eshop.product.application.product.dto;

import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.ProducerDto;

import java.util.UUID;

public record ProductDto(UUID id, String name, double price, int quantity, ProducerDto producer) {
}
