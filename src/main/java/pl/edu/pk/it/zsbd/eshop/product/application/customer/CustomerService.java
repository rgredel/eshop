package pl.edu.pk.it.zsbd.eshop.product.application.customer;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.AddCustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.CustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.mapper.CustomerMapper;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.Customer;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.CustomerRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres.CustomerEntity;

import java.util.List;
import java.util.UUID;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::toCustomerDto).toList();
    }

    public CustomerDto getCustomersById(UUID id) {
        Customer customer = customerRepository.findById(id);
        return customerMapper.toCustomerDto(customer);
    }

    public CustomerDto addCustomer(AddCustomerDto customerDto) {
        Customer Customer = customerMapper.toCustomer(customerDto);
        Customer save = customerRepository.save(Customer);
        return customerMapper.toCustomerDto(save);
    }

    public CustomerDto updateCustomer(UUID id, CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(id);
        if(existingCustomer == null) {
            throw new ObjectNotFoundException(id, CustomerEntity.class.getName());
        }
        Customer updatedCustomer = customerRepository.update(customerMapper.toCustomer(customerDto));
        return customerMapper.toCustomerDto(updatedCustomer);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.delete(id);
    }
}