package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;

public class AtualizarRecebimentoCaseImpl implements AtualizarRecebimentoCase {

    private final ReceivingGateway receivingGateway;

    public AtualizarRecebimentoCaseImpl(ReceivingGateway receivingGateway) {
        this.receivingGateway = receivingGateway;
    }

    @Override
    public Receiving execute(Long id, Receiving receiving) {
        return receivingGateway.atualizarRecebimento(id, receiving);
    }
}
