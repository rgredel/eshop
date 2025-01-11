package pl.edu.pk.it.zsbd.eshop.product.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.CustomerService;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.AddCustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.CustomerDto;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public CustomerDto getCustomerById(@PathVariable UUID id) {
        return customerService.getCustomersById(id);
    }

    @GetMapping()
    public List<CustomerDto> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer")
    public CustomerDto addCustomer(@RequestBody AddCustomerDto dto) {
        return customerService.addCustomer(dto);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}