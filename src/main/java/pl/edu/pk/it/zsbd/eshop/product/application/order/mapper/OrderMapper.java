package pl.edu.pk.it.zsbd.eshop.product.application.order.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.mapper.CustomerMapper;
import pl.edu.pk.it.zsbd.eshop.product.application.order.dto.AddOrderDto;
import pl.edu.pk.it.zsbd.eshop.product.application.order.dto.OrderDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.mapper.ProductMapper;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.Order;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.OrderId;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Quantity;

import java.time.Instant;

@Component
public class OrderMapper {
    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    public OrderMapper(CustomerMapper customerMapper, ProductMapper productMapper) {
        this.customerMapper = customerMapper;
        this.productMapper = productMapper;
    }

    public OrderDto toOrderDto(Order order) {
        return new OrderDto(
                order.getId().id(),
                customerMapper.toCustomerDto(order.getCustomer()),
                productMapper.toProductDto(order.getProduct()),
                order.getQuantity().value(),
                order.getOrderDate()
        );
    }

    public Order toOrder(OrderDto orderDto) {
        return new Order(
                new OrderId(orderDto.id()),
                customerMapper.toCustomer(orderDto.customer()),
                productMapper.toProduct(orderDto.productDto()),
                new Quantity(orderDto.quantity()),
                orderDto.orderDate()
        );
    }

    public Order toOrder(AddOrderDto addOrderDto) {
        return new Order(
                new OrderId(),
                customerMapper.toCustomer(addOrderDto.customer()),
                productMapper.toProduct(addOrderDto.product()),
                new Quantity(addOrderDto.quantity()),
                Instant.now()
        );
    }
}
