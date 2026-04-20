package dev.samuel.ReceivingController.infra.exception.handle;

public class RecebimentoNotFoundException extends RuntimeException {

    public RecebimentoNotFoundException(Long id) {
        super("Recebimeto não encontrado com o id: " + id);
    }

}
