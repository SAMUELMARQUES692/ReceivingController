package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;

public class CadastrarRecebimentoCaseImpl implements CadastrarRecebimentoCase{

    private final ReceivingGateway receivingGateway;

    public CadastrarRecebimentoCaseImpl(ReceivingGateway receivingGateway) {
        this.receivingGateway = receivingGateway;
    }

    public Receiving execute(Receiving receiving) {
        return null;
    }

}
