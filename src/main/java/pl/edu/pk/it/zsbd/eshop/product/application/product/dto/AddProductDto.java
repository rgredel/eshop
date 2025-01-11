package pl.edu.pk.it.zsbd.eshop.product.application.product.dto;

import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.ProducerDto;

public record AddProductDto(String name, int price, int quantity, ProducerDto producer) {
}
