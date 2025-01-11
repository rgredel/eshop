package pl.edu.pk.it.zsbd.eshop.product.application.product.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.mapper.ProducerMapper;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.AddProductDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.ProductDto;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Price;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Product;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.ProductId;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Quantity;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class ProductMapper {
    private final ProducerMapper producerMapper;

    public ProductMapper(ProducerMapper producerMapper) {
        this.producerMapper = producerMapper;
    }

    public ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId().id(),
                product.getName(),
                product.getPrice().value().doubleValue(),
                product.getQuantity().value(),
                product.getProducer() != null ? producerMapper.toProducerDto(product.getProducer()) : null
        );
    }

    public Product toProduct(ProductDto productDto) {
        return new Product(
                new ProductId(productDto.id()),
                productDto.name(),
                new Price(BigDecimal.valueOf(productDto.price())),
                new Quantity(productDto.quantity()),
                producerMapper.toProducer(productDto.producer())
        );
    }

    public Product toProduct(AddProductDto productDto) {
        return new Product(
                new ProductId(UUID.randomUUID()),
                productDto.name(),
                new Price(BigDecimal.valueOf(productDto.price())),
                new Quantity(productDto.quantity()),
                producerMapper.toProducer(productDto.producer())
        );
    }
}
