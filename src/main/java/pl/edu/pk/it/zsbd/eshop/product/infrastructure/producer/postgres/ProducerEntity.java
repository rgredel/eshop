package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres;

import jakarta.persistence.*;
import lombok.Data;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres.ProductEntity;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class ProducerEntity {
    @Id
    private UUID id;
    private String name;
    private String mail;
    private Long phoneNumber;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProductEntity> products;
}
