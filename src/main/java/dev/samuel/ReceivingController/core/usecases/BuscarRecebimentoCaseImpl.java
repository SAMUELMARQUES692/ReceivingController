package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;

import java.util.List;

public class BuscarRecebimentoCaseImpl implements BuscarRecebimentoCase{

    private final ReceivingGateway receivingGateway;

    public BuscarRecebimentoCaseImpl(ReceivingGateway receivingGateway) {
        this.receivingGateway = receivingGateway;
    }

    public List<Receiving> execute() {
        return receivingGateway.buscarRecebimetnos();
    }

}
