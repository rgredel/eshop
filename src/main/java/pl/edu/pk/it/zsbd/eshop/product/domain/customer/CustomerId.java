package pl.edu.pk.it.zsbd.eshop.product.domain.customer;

import org.springframework.util.Assert;

import java.util.UUID;

public record CustomerId(UUID id) {
    public CustomerId {
        Assert.notNull(id, "Id cannot be null");
    }

    public CustomerId() {
        this(UUID.randomUUID());
    }
}
