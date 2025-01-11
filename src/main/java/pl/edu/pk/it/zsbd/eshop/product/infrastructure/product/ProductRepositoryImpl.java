package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Product;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.ProductRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb.MongoProductRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres.JpaProductRepository;

import java.util.List;
import java.util.UUID;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryImpl.class);
    private final JpaProductRepository jpaProductRepository;
    private final MongoProductRepository mongoProductRepository;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository, MongoProductRepository mongoProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
        this.mongoProductRepository = mongoProductRepository;
    }

    @Override
    public Product save(Product product) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProductRepository.save(product);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_save_product: {}", watch.getTime());

        watch.reset();

        watch.start();
        Product save = jpaProductRepository.save(product);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_save_product: {}", watch.getTime());
        return save;
    }

    @Override
    public Product update(Product product) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProductRepository.update(product);
        LOGGER.info("Elapsed_time_for_mongo_update_product: {}", watch.getTime());
        watch.stop();

        watch.reset();

        watch.start();
        Product result = jpaProductRepository.update(product);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_update_product: {}", watch.getTime());

        return result;
    }

    @Override
    public Product findById(UUID id) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProductRepository.findById(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_findById_product: {}", watch.getTime());

        watch.reset();

        watch.start();
        Product result = jpaProductRepository.findById(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_findById_product: {}", watch.getTime());

        return result;
    }

    @Override
    public void delete(UUID id) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProductRepository.delete(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_delete_product: {}", watch.getTime());

        watch.reset();

        watch.start();
        jpaProductRepository.delete(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_delete_product: {}", watch.getTime());
    }

    @Override
    public List<Product> findAll() {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProductRepository.findAll();
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_findAll_product: {}", watch.getTime());

        watch.reset();

        watch.start();
        List<Product> result = jpaProductRepository.findAll();
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_findAll_product: {}", watch.getTime());
        return result;
    }
}