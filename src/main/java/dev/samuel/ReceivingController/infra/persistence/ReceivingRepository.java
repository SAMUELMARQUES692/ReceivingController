package dev.samuel.ReceivingController.infra.persistence;

import dev.samuel.ReceivingController.core.entities.Receiving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceivingRepository extends JpaRepository<ReceivingModel, Long> {

    Optional<Receiving> findByTicket(String ticket);

}
