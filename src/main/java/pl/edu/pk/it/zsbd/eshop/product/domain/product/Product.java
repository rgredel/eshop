package pl.edu.pk.it.zsbd.eshop.product.domain.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;
import pl.edu.pk.it.zsbd.eshop.product.domain.producer.Producer;

@Getter
public class Product {
    private ProductId id;
    private String name;
    private Price price;
    private Quantity quantity;
    @Setter
    private Producer producer;

    public Product(ProductId productId, String name, Price price, Quantity quantity, Producer producer) {
        Assert.notNull(name, "Name cannot be null");
        this.id = productId;
        this.quantity = quantity;
        this.price =  price;
        this.name = name;
        this.producer = producer;
    }

    Product() {
    }

}
