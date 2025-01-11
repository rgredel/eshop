package pl.edu.pk.it.zsbd.eshop.product.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.it.zsbd.eshop.product.application.order.OrderService;
import pl.edu.pk.it.zsbd.eshop.product.application.order.dto.AddOrderDto;
import pl.edu.pk.it.zsbd.eshop.product.application.order.dto.OrderDto;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public OrderDto getOrderById(@PathVariable UUID id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/order")
    public OrderDto addOrder(@RequestBody AddOrderDto addOrderDto) {
        return orderService.addOrder(addOrderDto);
    }

    @PutMapping("/order/{id}")
    public OrderDto updateOrder(@PathVariable UUID id, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}