package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;

public class BuscarRecebimentoPorIdImpl implements BuscarRecebimentoPorIdCase {

    private final ReceivingGateway receivingGateway;

    public BuscarRecebimentoPorIdImpl(ReceivingGateway receivingGateway) {
        this.receivingGateway = receivingGateway;
    }

    @Override
    public Receiving execute(Long id) {
        return receivingGateway.buscarPorRecebimentoPorId(id);
    }
}
