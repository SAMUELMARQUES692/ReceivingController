package dev.samuel.ReceivingController.core.entities;

import dev.samuel.ReceivingController.core.enums.TipoCarro;

import java.time.LocalDateTime;

public record Receiving(
        Long id,
        String nomeEmpresa,
        String nomeTrasnportadora,
        TipoCarro tipoCarro,
        String notasFiscais,
        LocalDateTime horarioMarcado,
        LocalDateTime horarioInical,
        LocalDateTime horarioDeFinalizacao,
        String observacoes) {
}
