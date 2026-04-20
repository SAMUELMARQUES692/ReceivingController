package dev.samuel.ReceivingController.infra.gateway;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;
import dev.samuel.ReceivingController.infra.exception.handle.RecebimentoNotFoundException;
import dev.samuel.ReceivingController.infra.mapper.ReceivingModelMapper;
import dev.samuel.ReceivingController.infra.persistence.ReceivingModel;
import dev.samuel.ReceivingController.infra.persistence.ReceivingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Receiving> buscarRecebimentos() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Receiving buscarPorRecebimentoPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new RecebimentoNotFoundException(id));
    }


    @Override
    public Receiving atualizarRecebimento(Long id, Receiving receiving) {
                repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recebimento com ID " + id + " não encontrado"));

        ReceivingModel recebimentoAtualizado = mapper.toModel(receiving);
        recebimentoAtualizado.setId(id);

        return mapper.toDomain(repository.save(recebimentoAtualizado));
    }

    @Override
    public void deletarRecebimento(Long id) {
                repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recebimento com ID " + id + " não encontrado"));

        repository.deleteById(id);
    }

    @Override
    public boolean existePorTicket(String ticket) {
        return repository.findAll().stream()
                .anyMatch(receiving -> receiving.getTicket().equalsIgnoreCase(ticket));
    }
}
