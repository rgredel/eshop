package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres.CustomerEntity;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres.ProductEntity;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
public class OrderEntity {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    private int quantity;
    private Instant orderDate;
}
