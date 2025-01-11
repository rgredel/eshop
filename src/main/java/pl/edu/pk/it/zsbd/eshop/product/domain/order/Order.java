package pl.edu.pk.it.zsbd.eshop.product.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.edu.pk.it.zsbd.eshop.product.domain.customer.Customer;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Product;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Quantity;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Order {
    private OrderId id;
    private Customer customer;
    private Product product;
    private Quantity quantity;
    private Instant orderDate;
}
