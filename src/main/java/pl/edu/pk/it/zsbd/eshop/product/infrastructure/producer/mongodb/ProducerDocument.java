package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "producers")
@Data
public class ProducerDocument {
    @Id
    private UUID id;
    private String name;
    private String mail;
    private Long phoneNumber;
}