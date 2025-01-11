package pl.edu.pk.it.zsbd.eshop.product.infrastructure.order.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, UUID> {
}