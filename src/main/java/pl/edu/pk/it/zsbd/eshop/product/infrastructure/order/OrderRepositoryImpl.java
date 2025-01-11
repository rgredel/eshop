package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.Order;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.OrderRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.mongodb.MongoOrderRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres.JpaOrderRepository;

import java.util.List;
import java.util.UUID;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRepositoryImpl.class);
    private final JpaOrderRepository jpaOrderRepository;
    private final MongoOrderRepository mongoOrderRepository;

    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository, MongoOrderRepository mongoOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.mongoOrderRepository = mongoOrderRepository;
    }

    @Override
    public Order save(Order order) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoOrderRepository.save(order);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_save_order: {}", watch.getTime());

        watch.reset();

        watch.start();
        Order save = jpaOrderRepository.save(order);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_save_order: {}", watch.getTime());
        return save;
    }

    @Override
    public Order update(Order order) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoOrderRepository.update(order);
        LOGGER.info("Elapsed_time_for_mongo_update_order: {}", watch.getTime());
        watch.stop();

        watch.reset();

        watch.start();
        Order result = jpaOrderRepository.update(order);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_update_order: {}", watch.getTime());

        return result;
    }

    @Override
    public Order findById(UUID id) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoOrderRepository.findById(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_findById_order: {}", watch.getTime());

        watch.reset();

        watch.start();
        Order result = jpaOrderRepository.findById(id);
        watch.stop();

        LOGGER.info("Elapsed_time_for_psql_findById_order: {}", watch.getTime());

        return result;
    }

    @Override
    public void delete(UUID id) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoOrderRepository.delete(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_delete_order: {}", watch.getTime());

        watch.reset();

        watch.start();
        jpaOrderRepository.delete(id);
        watch.stop();

        LOGGER.info("Elapsed_time_for_psql_delete_order: {}", watch.getTime());
    }

    @Override
    public List<Order> findAll() {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoOrderRepository.findAll();
        watch.stop();

        LOGGER.info("Elapsed_time_for_mongo_findAll_order: {}", watch.getTime());

        watch.reset();

        watch.start();
        List<Order> result = jpaOrderRepository.findAll();
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_findAll_order: {}", watch.getTime());
        return result;
    }
}
