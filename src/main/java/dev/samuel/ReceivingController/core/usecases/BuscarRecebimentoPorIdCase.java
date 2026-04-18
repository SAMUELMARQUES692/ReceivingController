package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;

public interface BuscarRecebimentoPorIdCase {

    Receiving execute(Long id);

}
