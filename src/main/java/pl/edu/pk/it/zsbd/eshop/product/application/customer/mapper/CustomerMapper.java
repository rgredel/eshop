package pl.edu.pk.it.zsbd.eshop.product.application.customer.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.AddCustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.CustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.Customer;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.CustomerId;

@Component
public class CustomerMapper {

    public CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId().id(),
                customer.getFirstName(),
                customer.getLastName()
        );
    }

    public Customer toCustomer(CustomerDto customerDto) {
        return new Customer(
                new CustomerId(customerDto.id()),
                customerDto.firstName(),
                customerDto.lastName()
        );
    }

    public Customer toCustomer(AddCustomerDto customerDto) {
        return new Customer(
                new CustomerId(),
                customerDto.firstName(),
                customerDto.lastName()
        );
    }
}
