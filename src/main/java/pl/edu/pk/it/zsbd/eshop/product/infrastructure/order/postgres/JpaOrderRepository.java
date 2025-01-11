package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.Order;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres.mapper.OrderEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class JpaOrderRepository {
    private final OrderEntityRepository orderEntityRepository;
    private final OrderEntityMapper orderEntityMapper;

    public JpaOrderRepository(OrderEntityRepository orderEntityRepository, OrderEntityMapper orderEntityMapper) {
        this.orderEntityRepository = orderEntityRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    public Order save(Order order) {
        OrderEntity entity = orderEntityMapper.toEntity(order);
        orderEntityRepository.save(entity);
        return order;
    }

    public Order update(Order order) {
        OrderEntity entity = orderEntityMapper.toEntity(order);
        orderEntityRepository.save(entity);
        return order;
    }

    public Order findById(UUID id) {
        Optional<OrderEntity> byId = orderEntityRepository.findById(id);
        OrderEntity entities = byId.orElseThrow();
        return orderEntityMapper.toDomain(entities);
    }

    public void delete(UUID id) {
        Optional<OrderEntity> entities = orderEntityRepository.findById(id);
        entities.ifPresent(orderEntityRepository::delete);
    }

    public List<Order> findAll() {
        List<OrderEntity> entities = orderEntityRepository.findAll();
        return entities.stream().map(orderEntityMapper::toDomain).toList();
    }
}
