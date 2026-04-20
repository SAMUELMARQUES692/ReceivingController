package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;
import dev.samuel.ReceivingController.infra.exception.TicketNotFoundException;

public class FiltroTicketCaseImpl implements FiltroTicketCase {

    private final ReceivingGateway receivingGateway;

    public FiltroTicketCaseImpl(ReceivingGateway receivingGateway) {
        this.receivingGateway = receivingGateway;
    }

    @Override
    public Receiving execute(String ticket) {
        return receivingGateway.filtrarPorTicket(ticket)
                .orElseThrow(() -> new TicketNotFoundException(ticket));
    }

}
