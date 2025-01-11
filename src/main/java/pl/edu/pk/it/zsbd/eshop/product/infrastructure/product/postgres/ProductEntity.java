package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres;

import jakarta.persistence.*;
import lombok.Data;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres.OrderEntity;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres.ProducerEntity;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class ProductEntity {
    @Id
    private UUID id;
    private String name;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private ProducerEntity producer;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderEntity> orders;

}
