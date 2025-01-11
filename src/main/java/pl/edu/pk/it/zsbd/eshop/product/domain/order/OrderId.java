package pl.edu.pk.it.zsbd.eshop.product.domain.order;

import org.springframework.util.Assert;

import java.util.UUID;

public record OrderId(UUID id) {
    public OrderId {
        Assert.notNull(id, "Id cannot be null");
    }

    public OrderId() {
        this(UUID.randomUUID());
    }
}
