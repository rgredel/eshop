package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.Customer;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres.mapper.CustomerEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaCustomerRepository{
    private final CustomerEntityRepository customerEntityRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public JpaCustomerRepository(CustomerEntityRepository customerEntityRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerEntityRepository = customerEntityRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toEntity(customer);
        customerEntityRepository.save(customerEntity);
        return customer;
    }

    public Customer update(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toEntity(customer);
        customerEntityRepository.save(customerEntity);
        return customer;
    }

    public Customer findById(UUID id) {
        Optional<CustomerEntity> byId = customerEntityRepository.findById(id);
        CustomerEntity customerEntity = byId.orElseThrow();
        return customerEntityMapper.toDomain(customerEntity);
    }

    public void delete(UUID id) {
        Optional<CustomerEntity> customerEntity = customerEntityRepository.findById(id);
        customerEntity.ifPresent(customerEntityRepository::delete);
    }

    public List<Customer> findAll() {
        List<CustomerEntity> customerEntities = customerEntityRepository.findAll();
        return customerEntities.stream().map(customerEntityMapper::toDomain).toList();
    }
}
