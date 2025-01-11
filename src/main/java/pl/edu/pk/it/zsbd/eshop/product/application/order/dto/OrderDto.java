package pl.edu.pk.it.zsbd.eshop.product.application.order.dto;

import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.CustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.ProductDto;

import java.time.Instant;
import java.util.UUID;

public record OrderDto(UUID id, CustomerDto customer, ProductDto productDto, int quantity, Instant orderDate) {
}
