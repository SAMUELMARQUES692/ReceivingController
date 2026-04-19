package dev.samuel.ReceivingController.core.gateway;

import dev.samuel.ReceivingController.core.entities.Receiving;

import java.util.List;
import java.util.Optional;

public interface ReceivingGateway {

    Receiving cadastrarRecebimento(Receiving receiving);

    List<Receiving> buscarRecebimetnos();

    Receiving buscarPorRecebimentoPorId(Long id);

    Receiving atualizarRecebimento(Long id, Receiving receiving);

    void deletarRecebimento(Long id);

}
