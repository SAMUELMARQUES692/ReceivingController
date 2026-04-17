package dev.samuel.ReceivingController.infra.dto;

import dev.samuel.ReceivingController.core.enums.TipoCarro;

import java.time.LocalDateTime;

public record ReceivingDTO(
        Long id,
        String nomeEmpresa,
        String nomeTransportadora,
        TipoCarro tipoCarro,
        String notasFiscais,
        LocalDateTime horarioMarcado,
        LocalDateTime horarioInicial,
        LocalDateTime horarioDeFinalizacao,
        String observacoes) {
}
