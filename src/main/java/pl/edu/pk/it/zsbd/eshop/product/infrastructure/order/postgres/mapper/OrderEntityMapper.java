package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.Order;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.OrderId;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Quantity;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres.mapper.CustomerEntityMapper;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres.OrderEntity;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres.mapper.ProductEntityMapper;

@Component
public class OrderEntityMapper {
    private final CustomerEntityMapper customerEntityMapper;
    private final ProductEntityMapper productEntityMapper;

    public OrderEntityMapper(CustomerEntityMapper customerEntityMapper, ProductEntityMapper productEntityMapper) {
        this.customerEntityMapper = customerEntityMapper;
        this.productEntityMapper = productEntityMapper;
    }

    public OrderEntity toEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId().id());
        orderEntity.setCustomer(customerEntityMapper.toEntity(order.getCustomer()));
        orderEntity.setProduct(productEntityMapper.toEntity(order.getProduct()));
        orderEntity.setQuantity(order.getQuantity().value());
        orderEntity.setOrderDate(order.getOrderDate());
        return orderEntity;
    }

    public Order toDomain(OrderEntity orderEntity) {
        return new Order(
            new OrderId(orderEntity.getId()),
            customerEntityMapper.toDomain(orderEntity.getCustomer()),
            productEntityMapper.toDomain(orderEntity.getProduct()),
            new Quantity(orderEntity.getQuantity()),
            orderEntity.getOrderDate()
        );
    }
}