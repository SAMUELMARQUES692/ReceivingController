package dev.samuel.ReceivingController.infra.exception;

public class TicketNotFoundException extends RuntimeException{

    public TicketNotFoundException(String ticket) {
        super("Ticket " + ticket + " não encontrado");
    }
}
