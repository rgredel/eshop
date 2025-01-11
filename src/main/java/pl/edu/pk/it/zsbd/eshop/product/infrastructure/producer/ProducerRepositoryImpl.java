package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Producer;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.ProducerRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb.MongoProducerRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres.JpaProducerRepository;

import java.util.List;
import java.util.UUID;

@Component
public class ProducerRepositoryImpl implements ProducerRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerRepositoryImpl.class);
    private final JpaProducerRepository jpaProducerRepository;
    private final MongoProducerRepository mongoProducerRepository;

    public ProducerRepositoryImpl(JpaProducerRepository jpaProducerRepository, MongoProducerRepository mongoProducerRepository) {
        this.jpaProducerRepository = jpaProducerRepository;
        this.mongoProducerRepository = mongoProducerRepository;
    }

    @Override
    public Producer save(Producer producer) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProducerRepository.save(producer);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_save_producer: {}", watch.getTime());

        watch.reset();

        watch.start();
        Producer save = jpaProducerRepository.save(producer);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_save_producer: {}", watch.getTime());
        return save;
    }

    @Override
    public Producer update(Producer producer) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProducerRepository.update(producer);
        LOGGER.info("Elapsed_time_for_mongo_update_producer: {}", watch.getTime());
        watch.stop();

        watch.reset();

        watch.start();
        Producer result = jpaProducerRepository.update(producer);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_update_producer: {}", watch.getTime());

        return result;
    }

    @Override
    public Producer findById(UUID id) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProducerRepository.findById(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_findById_producer: {}", watch.getTime());

        watch.reset();

        watch.start();
        Producer result = jpaProducerRepository.findById(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_findById_producer: {}", watch.getTime());

        return result;
    }

    @Override
    public void delete(UUID id) {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProducerRepository.delete(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_delete_producer: {}", watch.getTime());

        watch.reset();

        watch.start();
        jpaProducerRepository.delete(id);
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_delete_producer: {}", watch.getTime());
    }

    @Override
    public List<Producer> findAll() {
        StopWatch watch = new StopWatch();
        watch.start();
        mongoProducerRepository.findAll();
        watch.stop();
        LOGGER.info("Elapsed_time_for_mongo_findAll_producer: {}", watch.getTime());

        watch.reset();

        watch.start();
        List<Producer> result = jpaProducerRepository.findAll();
        watch.stop();
        LOGGER.info("Elapsed_time_for_psql_findAll_producer: {}", watch.getTime());
        return result;
    }
}