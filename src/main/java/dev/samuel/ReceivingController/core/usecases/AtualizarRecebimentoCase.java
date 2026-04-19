package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;

public interface AtualizarRecebimentoCase {

    Receiving execute(Long id, Receiving receiving);
}
