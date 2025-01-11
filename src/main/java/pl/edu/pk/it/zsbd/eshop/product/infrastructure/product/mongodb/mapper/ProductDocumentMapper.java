package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Price;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Product;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.ProductId;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Quantity;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.mongodb.mapper.ProducerDocumentMapper;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.mongodb.ProductDocument;

import java.math.BigDecimal;

@Component
public class ProductDocumentMapper {
    private final ProducerDocumentMapper producerDocumentMapper;

    public ProductDocumentMapper(ProducerDocumentMapper producerEntityMapper) {
        this.producerDocumentMapper = producerEntityMapper;
    }

    public ProductDocument toDocument(Product product) {
        ProductDocument productDocument = new ProductDocument();
        productDocument.setId(product.getId().id());
        productDocument.setName(product.getName());
        productDocument.setPrice(product.getPrice().value().doubleValue());
        productDocument.setQuantity(product.getQuantity().value());
        productDocument.setProducer(producerDocumentMapper.toDocument(product.getProducer()));
        return productDocument;
    }

    public Product toDomain(ProductDocument productDocument) {
        return new Product(
            new ProductId(productDocument.getId()),
            productDocument.getName(),
            new Price(BigDecimal.valueOf(productDocument.getPrice())),
            new Quantity(productDocument.getQuantity()),
            producerDocumentMapper.toDomain(productDocument.getProducer())
        );
    }
}