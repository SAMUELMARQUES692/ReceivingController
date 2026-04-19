package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;

public class DeletarRecebimentoCaseImpl implements DeletarRecebimentoCase{

    private final ReceivingGateway receivingGateway;

    public DeletarRecebimentoCaseImpl(ReceivingGateway receivingGateway) {
        this.receivingGateway = receivingGateway;
    }

    @Override
    public void execute(Long id) {
        receivingGateway.deletarRecebimento(id);
    }
}
