package dev.samuel.ReceivingController.infra.exception;

public class ReceivingNotFoundException extends RuntimeException {

    public ReceivingNotFoundException(Long id) {
        super("Recebimeto não encontrado com o id: " + id);
    }

}
