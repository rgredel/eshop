package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.Customer;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.CustomerId;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres.CustomerEntity;

@Component
public class CustomerEntityMapper {

    public CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId().id());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        return customerEntity;
    }

    public Customer toDomain(CustomerEntity customerEntity) {
        return new Customer(
            new CustomerId(customerEntity.getId()),
            customerEntity.getFirstName(),
            customerEntity.getLastName()
        );
    }
}