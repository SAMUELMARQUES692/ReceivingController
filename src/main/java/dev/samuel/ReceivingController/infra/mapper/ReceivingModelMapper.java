package dev.samuel.ReceivingController.infra.mapper;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.infra.persistence.ReceivingModel;
import org.springframework.stereotype.Component;

@Component
public class ReceivingModelMapper {

    public ReceivingModel toModel(Receiving receiving) {
        return new ReceivingModel(
                receiving.id(),
                receiving.nomeEmpresa(),
                receiving.nomeTrasnportadora(),
                receiving.tipoCarro(),
                receiving.ticket(),
                receiving.notasFiscais(),
                receiving.horarioMarcado(),
                receiving.horarioInical(),
                receiving.horarioDeFinalizacao(),
                receiving.observacoes()
        );
    }

    public Receiving toDomain(ReceivingModel receivingModel) {
        return new Receiving(
                receivingModel.getId(),
                receivingModel.getNomeEmpresa(),
                receivingModel.getNomeTransportadora(),
                receivingModel.getTipoCarro(),
                receivingModel.getTicket(),
                receivingModel.getNotasFiscais(),
                receivingModel.getHorarioMarcado(),
                receivingModel.getHorarioInicial(),
                receivingModel.getHorarioDeFinalizacao(),
                receivingModel.getObservacoes()
        );
    }
}
