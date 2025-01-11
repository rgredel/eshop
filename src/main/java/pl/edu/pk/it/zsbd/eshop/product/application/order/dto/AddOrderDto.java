package pl.edu.pk.it.zsbd.eshop.product.application.order.dto;

import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.CustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.ProductDto;

public record AddOrderDto(CustomerDto customer, ProductDto product, int quantity) {
}
