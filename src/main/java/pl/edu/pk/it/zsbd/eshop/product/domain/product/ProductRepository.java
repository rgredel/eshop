package pl.edu.pk.it.zsbd.eshop.product.domain.product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    Product save(Product product);
    Product update(Product product);
    Product findById(UUID id);

    void delete(UUID id);

    List<Product> findAll();
}
