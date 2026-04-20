package dev.samuel.ReceivingController.infra.dto;

import dev.samuel.ReceivingController.core.enums.TipoCarro;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReceivingDTO(
        Long id,
        String nomeEmpresa,
        String nomeTransportadora,
        TipoCarro tipoCarro,
        String ticket,
        String notasFiscais,
        LocalDateTime horarioMarcado,
        LocalDateTime horarioInicial,
        LocalDateTime horarioDeFinalizacao,
        String observacoes) {
}
