package pl.edu.pk.it.zsbd.eshop.product.application.customer.dto;

import java.util.UUID;

public record CustomerDto(UUID id, String firstName, String lastName) {
}
