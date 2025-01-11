package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb.ProducerDocument;

import java.util.UUID;

@Document(collection = "products")
@Data
public class ProductDocument {
    @Id
    private UUID id;
    private String name;
    private double price;
    private int quantity;

    @DBRef
    private ProducerDocument producer;
}