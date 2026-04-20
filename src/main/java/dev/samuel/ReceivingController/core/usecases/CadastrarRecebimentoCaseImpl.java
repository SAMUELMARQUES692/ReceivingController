package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;
import dev.samuel.ReceivingController.infra.exception.handle.DuplicateReceivingException;

public class CadastrarRecebimentoCaseImpl implements CadastrarRecebimentoCase{

    private final ReceivingGateway receivingGateway;

    public CadastrarRecebimentoCaseImpl(ReceivingGateway receivingGateway) {
        this.receivingGateway = receivingGateway;
    }

    public Receiving execute(Receiving receiving) {

        if (receivingGateway.existePorTicket(receiving.ticket())) {
            throw new DuplicateReceivingException(receiving.ticket());
        }
        return receivingGateway.cadastrarRecebimento(receiving);
    }



}
