package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres;

import jakarta.persistence.*;
import lombok.Data;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres.OrderEntity;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class CustomerEntity {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderEntity> orders;
}
