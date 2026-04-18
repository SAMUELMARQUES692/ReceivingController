package dev.samuel.ReceivingController.core.gateway;

import dev.samuel.ReceivingController.core.entities.Receiving;

import java.util.List;

public interface ReceivingGateway {

    Receiving cadastrarRecebimento(Receiving receiving);

    List<Receiving> buscarRecebimetnos();

}
