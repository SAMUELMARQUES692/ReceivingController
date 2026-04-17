package dev.samuel.ReceivingController.infra.gateway;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;
import dev.samuel.ReceivingController.infra.mapper.ReceivingModelMapper;
import dev.samuel.ReceivingController.infra.persistence.ReceivingModel;
import dev.samuel.ReceivingController.infra.persistence.ReceivingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReceivingRepositoryGateway implements ReceivingGateway {

    private final ReceivingRepository repository;
    private final ReceivingModelMapper mapper;

    @Override
    public Receiving cadastrarRecebimento(Receiving receiving) {
        ReceivingModel salvar = repository.save(mapper.toModel(receiving));
        return mapper.toDomain(salvar);
    }
}
