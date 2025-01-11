package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Price;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Product;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.ProductId;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Quantity;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres.mapper.ProducerEntityMapper;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres.ProductEntity;

import java.math.BigDecimal;

@Component
public class ProductEntityMapper {
    private final ProducerEntityMapper producerEntityMapper;

    public ProductEntityMapper(ProducerEntityMapper producerEntityMapper) {
        this.producerEntityMapper = producerEntityMapper;
    }

    public ProductEntity toEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId().id());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice().value().doubleValue());
        productEntity.setQuantity(product.getQuantity().value());
        productEntity.setProducer(producerEntityMapper.toEntity(product.getProducer()));
        return productEntity;
    }

    public Product toDomain(ProductEntity productEntity) {
        return new Product(
            new ProductId(productEntity.getId()),
            productEntity.getName(),
            new Price(BigDecimal.valueOf(productEntity.getPrice())),
            new Quantity(productEntity.getQuantity()),
            producerEntityMapper.toDomain(productEntity.getProducer())
        );
    }
}