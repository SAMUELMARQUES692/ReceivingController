package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;

public interface BuscarRecebimentoCase {

    public Receiving execute(Long id);

}
