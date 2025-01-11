package pl.edu.pk.it.zsbd.eshop.product.domain.product;

import org.springframework.util.Assert;

import java.util.UUID;

public record ProductId(UUID id) {
    public ProductId {
        Assert.notNull(id, "Id cannot be null");
    }

    public ProductId() {
        this(UUID.randomUUID());
    }
}
