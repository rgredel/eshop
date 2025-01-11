package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.Customer;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.CustomerRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb.MongoCustomerRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres.JpaCustomerRepository;

import java.util.List;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepositoryImpl.class);
    private final JpaCustomerRepository jpaCustomerRepository;
    private final MongoCustomerRepository mongoCustomerRepository;

    public CustomerRepositoryImpl(JpaCustomerRepository jpaCustomerRepository, MongoCustomerRepository mongoCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.mongoCustomerRepository = mongoCustomerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoCustomerRepository.save(customer);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_save_customer: {}", watch.getTime());

        watch.reset();

        watch.start();
        Customer save = jpaCustomerRepository.save(customer);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_save_customer: {}", watch.getTime());
        return save;
    }

    @Override
    public Customer update(Customer customer) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoCustomerRepository.update(customer);
        LOGGER.info("Elapsed_time_for_mongo_update_customer: {}", watch.getTime());
        watch.stop();

        watch.reset();

        watch.start();
        Customer result = jpaCustomerRepository.update(customer);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_update_customer: {}", watch.getTime());

        return result;
    }

    @Override
    public Customer findById(UUID id) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoCustomerRepository.findById(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_findById_customer: {}", watch.getTime());

        watch.reset();

        watch.start();
        Customer result = jpaCustomerRepository.findById(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_findById_customer: {}", watch.getTime());

        return result;
    }

    @Override
    public void delete(UUID id) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoCustomerRepository.delete(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_delete_customer: {}", watch.getTime());

        watch.reset();

        watch.start();
        jpaCustomerRepository.delete(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_delete_customer: {}", watch.getTime());
    }

    @Override
    public List<Customer> findAll() {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoCustomerRepository.findAll();
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_findAll_customer: {}", watch.getTime());

        watch.reset();

        watch.start();
        List<Customer> result = jpaCustomerRepository.findAll();
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_findAll_customer: {}", watch.getTime());
        return result;
    }
}