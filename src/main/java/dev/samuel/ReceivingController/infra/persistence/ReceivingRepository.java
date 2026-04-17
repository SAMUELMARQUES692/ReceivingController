package dev.samuel.ReceivingController.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivingRepository extends JpaRepository<ReceivingModel, Long> {
}
