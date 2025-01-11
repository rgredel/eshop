package pl.edu.pk.it.zsbd.eshop.product.domain.order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    Order save(Order order);
    Order update(Order order);
    Order findById(UUID id);

    void delete(UUID id);

    List<Order> findAll();
}
