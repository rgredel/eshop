package pl.edu.pk.it.zsbd.eshop.product.infrastructure.producer.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProducerEntityRepository extends JpaRepository<ProducerEntity, UUID> {
}