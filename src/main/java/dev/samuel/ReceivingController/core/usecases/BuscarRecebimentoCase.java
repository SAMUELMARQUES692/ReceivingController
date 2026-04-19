package dev.samuel.ReceivingController.core.usecases;

import dev.samuel.ReceivingController.core.entities.Receiving;

import java.util.List;

public interface BuscarRecebimentoCase {

     List<Receiving> execute();

}
