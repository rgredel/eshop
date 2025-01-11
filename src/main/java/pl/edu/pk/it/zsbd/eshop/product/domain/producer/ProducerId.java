package pl.edu.pk.it.zsbd.eshop.product.domain.producer;

import org.springframework.util.Assert;

import java.util.UUID;

public record ProducerId(UUID id) {
    public ProducerId {
        Assert.notNull(id, "Id cannot be null");
    }

    public ProducerId() {
        this(UUID.randomUUID());
    }
}
