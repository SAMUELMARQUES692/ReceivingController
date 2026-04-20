package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;

public interface FiltroTicketCase {

    Receiving execute(String ticket);
}
