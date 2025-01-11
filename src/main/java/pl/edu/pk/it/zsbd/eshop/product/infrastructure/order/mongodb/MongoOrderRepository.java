package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.mongodb;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.Order;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.mongodb.mapper.OrderDocumentMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MongoOrderRepository{
    private final OrderDocumentRepository orderDocumentRepository;
    private final OrderDocumentMapper orderDocumentMapper;

    public MongoOrderRepository(OrderDocumentRepository orderDocumentRepository, OrderDocumentMapper orderDocumentMapper) {
        this.orderDocumentRepository = orderDocumentRepository;
        this.orderDocumentMapper = orderDocumentMapper;
    }

    public Order save(Order order) {
        OrderDocument entity = orderDocumentMapper.toDocument(order);
        orderDocumentRepository.save(entity);
        return order;
    }

    public Order update(Order order) {
        OrderDocument document = orderDocumentMapper.toDocument(order);
        orderDocumentRepository.save(document);
        return order;
    }
    
    public Order findById(UUID id) {
        Optional<OrderDocument> byId = orderDocumentRepository.findById(id);
        OrderDocument orderDocument = byId.orElseThrow();
        return orderDocumentMapper.toDomain(orderDocument);
    }

    public void delete(UUID id) {
        Optional<OrderDocument> byId = orderDocumentRepository.findById(id);
        byId.ifPresent(orderDocumentRepository::delete);
    }
    
    public List<Order> findAll() {
        List<OrderDocument> all = orderDocumentRepository.findAll();
        return all.stream().map(orderDocumentMapper::toDomain).toList();
    }
}
