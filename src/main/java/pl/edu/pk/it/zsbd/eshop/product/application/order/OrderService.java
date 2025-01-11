package pl.edu.pk.it.zsbd.eshop.product.application.order;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pk.it.zsbd.eshop.product.application.order.dto.AddOrderDto;
import pl.edu.pk.it.zsbd.eshop.product.application.order.dto.OrderDto;
import pl.edu.pk.it.zsbd.eshop.product.application.order.mapper.OrderMapper;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.Order;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.OrderRepository;

import java.util.List;
import java.util.UUID;


@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::toOrderDto).toList();
    }

    public OrderDto getOrderById(UUID id) {
        Order order = orderRepository.findById(id);
        return orderMapper.toOrderDto(order);
    }

    public OrderDto addOrder(AddOrderDto addOrderDto) {
        Order order = orderMapper.toOrder(addOrderDto);
        Order save = orderRepository.save(order);
        return orderMapper.toOrderDto(save);
    }

    public OrderDto updateOrder(UUID id, OrderDto orderDto) {
        Order existingOrder = orderRepository.findById(id);
        if(existingOrder == null) {
            throw new ObjectNotFoundException(id, OrderDto.class.getName());
        }
        Order updatedOrder = orderRepository.update(orderMapper.toOrder(orderDto));
        return orderMapper.toOrderDto(updatedOrder);
    }

    public void deleteOrder(UUID id) {
        orderRepository.delete(id);
    }
}