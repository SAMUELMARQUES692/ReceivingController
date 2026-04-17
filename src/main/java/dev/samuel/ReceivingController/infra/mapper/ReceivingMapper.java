package dev.samuel.ReceivingController.infra.mapper;

import dev.samuel.ReceivingController.core.entities.Receiving;
import dev.samuel.ReceivingController.infra.dto.ReceivingDTO;
import dev.samuel.ReceivingController.infra.persistence.ReceivingModel;
import org.springframework.stereotype.Component;

@Component
public class ReceivingMapper {

    public Receiving toDomain(ReceivingDTO receivingDTO) {
        return new Receiving(
                receivingDTO.id(),
                receivingDTO.nomeEmpresa(),
                receivingDTO.nomeTransportadora(),
                receivingDTO.tipoCarro(),
                receivingDTO.notasFiscais(),
                receivingDTO.horarioMarcado(),
                receivingDTO.horarioInicial(),
                receivingDTO.horarioDeFinalizacao(),
                receivingDTO.observacoes()
        );
    }


    public ReceivingDTO toDto(Receiving receiving) {

        return new ReceivingDTO(
                receiving.id(),
                receiving.nomeEmpresa(),
                receiving.nomeEmpresa(),
                receiving.tipoCarro(),
                receiving.notasFiscais(),
                receiving.horarioMarcado(),
                receiving.horarioInical(),
                receiving.horarioDeFinalizacao(),
                receiving.observacoes()
        );
    }

}
