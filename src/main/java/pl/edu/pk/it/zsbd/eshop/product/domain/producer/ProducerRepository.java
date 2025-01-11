package pl.edu.pk.it.zsbd.eshop.product.domain.producer;

import java.util.List;
import java.util.UUID;

public interface ProducerRepository {
    Producer save(Producer producer);
    Producer update(Producer producer);
    Producer findById(UUID id);

    void delete(UUID id);

    List<Producer> findAll();
}
