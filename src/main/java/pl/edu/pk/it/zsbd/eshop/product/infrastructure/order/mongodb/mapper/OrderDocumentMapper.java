package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.mongodb.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.Order;
import pl.edu.pk.it.zsbd.eshop.product.domain.order.OrderId;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Quantity;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.mongodb.mapper.CustomerDocumentMapper;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.mongodb.OrderDocument;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb.mapper.ProductDocumentMapper;

@Component
public class OrderDocumentMapper {
    private final CustomerDocumentMapper customerDocumentMapper;
    private final ProductDocumentMapper productDocumentMapper;

    public OrderDocumentMapper(CustomerDocumentMapper customerDocumentMapper, ProductDocumentMapper productDocumentMapper) {
        this.customerDocumentMapper = customerDocumentMapper;
        this.productDocumentMapper = productDocumentMapper;
    }

    public OrderDocument toDocument(Order order) {
        OrderDocument orderDocument = new OrderDocument();
        orderDocument.setId(order.getId().id());
        orderDocument.setCustomer(customerDocumentMapper.toDocument(order.getCustomer()));
        orderDocument.setProduct(productDocumentMapper.toDocument(order.getProduct()));
        orderDocument.setQuantity(order.getQuantity().value());
        orderDocument.setOrderDate(order.getOrderDate());
        return orderDocument;
    }

    public Order toDomain(OrderDocument orderDocument) {
        return new Order(
            new OrderId(orderDocument.getId()),
            customerDocumentMapper.toDomain(orderDocument.getCustomer()),
            productDocumentMapper.toDomain(orderDocument.getProduct()),
            new Quantity(orderDocument.getQuantity()),
            orderDocument.getOrderDate()
        );
    }
}