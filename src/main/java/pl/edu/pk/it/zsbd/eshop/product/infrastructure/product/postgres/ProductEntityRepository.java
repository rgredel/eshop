package pl.edu.pk.it.zsbd.eshop.product.infrastructure.product.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, UUID> {
}