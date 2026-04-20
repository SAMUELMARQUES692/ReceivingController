package dev.samuel.ReceivingController.core.entities;

import dev.samuel.ReceivingController.core.enums.TipoCarro;

import java.time.LocalDateTime;

public record Receiving(
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
