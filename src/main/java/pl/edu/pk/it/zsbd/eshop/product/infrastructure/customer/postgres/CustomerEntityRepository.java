package pl.edu.pk.it.zsbd.eshop.product.infrastructure.customer.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, UUID> {
}