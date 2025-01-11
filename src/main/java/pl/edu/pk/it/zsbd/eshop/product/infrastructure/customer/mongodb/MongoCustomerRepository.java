package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.Customer;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb.mapper.CustomerDocumentMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MongoCustomerRepository{
        private final CustomerDocumentRepository customerDocumentRepository;
        private final CustomerDocumentMapper customerDocumentMapper;

    public MongoCustomerRepository(CustomerDocumentRepository customerDocumentRepository, CustomerDocumentMapper customerDocumentMapper) {
        this.customerDocumentRepository = customerDocumentRepository;
        this.customerDocumentMapper = customerDocumentMapper;
    }


    public Customer save(Customer customer) {
            CustomerDocument customerEntity = customerDocumentMapper.toDocument(customer);
            customerDocumentRepository.save(customerEntity);
            return customer;
        }

        public Customer update(Customer customer) {
            CustomerDocument customerEntity = customerDocumentMapper.toDocument(customer);
            customerDocumentRepository.save(customerEntity);
            return customer;
        }

        public Customer findById(UUID id) {
            Optional<CustomerDocument> byId = customerDocumentRepository.findById(id);
            CustomerDocument customerDocument = byId.orElseThrow();
            return customerDocumentMapper.toDomain(customerDocument);
        }

        public void delete(UUID id) {
            Optional<CustomerDocument> customerEntity = customerDocumentRepository.findById(id);
            customerEntity.ifPresent(customerDocumentRepository::delete);
        }

        public List<Customer> findAll() {
            List<CustomerDocument> all = customerDocumentRepository.findAll();
            return all.stream().map(customerDocumentMapper::toDomain).toList();
        }

}
