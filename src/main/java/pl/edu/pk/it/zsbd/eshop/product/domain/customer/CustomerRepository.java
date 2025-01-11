package pl.edu.pk.it.zsbd.eshop.product.domain.customer;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);
    Customer update(Customer customer);
    Customer findById(UUID id);

    void delete(UUID id);

    List<Customer> findAll();
}
