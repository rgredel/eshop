package pl.edu.pk.it.zsbd.eshop.product.application.product;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.AddProductDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.ProductDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.mapper.ProductMapper;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.Product;
import pl.edu.pk.it.zsbd.eshop.product.domain.product.ProductRepository;
import pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres.ProductEntity;

import java.util.List;
import java.util.UUID;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toProductDto).toList();
    }

    public ProductDto getProductById(UUID id) {
        Product product = productRepository.findById(id);
        return productMapper.toProductDto(product);
    }

    public ProductDto addProduct(AddProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        Product save = productRepository.save(product);
        return productMapper.toProductDto(save);
    }

    public ProductDto updateProduct(UUID id, ProductDto productDetails) {
        Product existingProduct = productRepository.findById(id);
        if(existingProduct == null) {
            throw new ObjectNotFoundException(id, ProductEntity.class.getName());
        }
        Product updatedProduct = productRepository.update(productMapper.toProduct(productDetails));
        return productMapper.toProductDto(updatedProduct);
    }

    public void deleteProduct(UUID id) {
        productRepository.delete(id);
    }
}