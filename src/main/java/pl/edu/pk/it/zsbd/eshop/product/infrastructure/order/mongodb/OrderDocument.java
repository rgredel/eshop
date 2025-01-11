package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb.CustomerDocument;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb.ProductDocument;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "orders")
@Data
public class OrderDocument {
    @Id
    private UUID id;
    @DBRef
    private ProductDocument product;
    @DBRef
    private CustomerDocument customer;
    private int quantity;
    private Instant orderDate;
}