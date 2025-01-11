package pl.edu.pk.it.zsbd.eshop.product.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.AddProductDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.ProductDto;

import pl.edu.pk.it.zsbd.eshop.product.application.product.ProductService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ProductDto getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public ProductDto addProduct(@RequestBody AddProductDto product) {
        return productService.addProduct(product);
    }

    @PutMapping("/product/{id}")
    public ProductDto updateProduct(@PathVariable UUID id, @RequestBody ProductDto product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}