package dev.samuel.ReceivingController.infra.exception;

public class DuplicateReceivingException extends RuntimeException{

    public DuplicateReceivingException(String ticket) {
        super("Ticket " + ticket + " já existe em outro recebimento");
    }
}
