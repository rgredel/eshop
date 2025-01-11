package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.Customer;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.CustomerId;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb.CustomerDocument;

@Component
public class CustomerDocumentMapper {

    public CustomerDocument toDocument(Customer customer) {
        CustomerDocument customerDocument = new CustomerDocument();
        customerDocument.setId(customer.getId().id());
        customerDocument.setFirstName(customer.getFirstName());
        customerDocument.setLastName(customer.getLastName());
        return customerDocument;
    }

    public Customer toDomain(CustomerDocument customerDocument) {
        return new Customer(
            new CustomerId(customerDocument.getId()),
            customerDocument.getFirstName(),
            customerDocument.getLastName()
        );
    }
}