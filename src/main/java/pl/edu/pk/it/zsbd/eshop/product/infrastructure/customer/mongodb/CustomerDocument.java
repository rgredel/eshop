package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "customers")
@Data
public class CustomerDocument {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
}