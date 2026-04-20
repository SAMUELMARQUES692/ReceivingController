package dev.samuel.ReceivingController.infra.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.samuel.ReceivingController.core.enums.TipoCarro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "controle_recebimentos")
public class ReceivingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nomeEmpresa;

    @Column(length = 100, nullable = false)
    private String nomeTransportadora;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private TipoCarro tipoCarro;

    @Column(length = 50, nullable = false, unique = true)
    private String ticket;

    @Column(length = 200)
    private String notasFiscais;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    @Column(nullable = false)
    private LocalDateTime horarioMarcado;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime horarioInicial;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime horarioDeFinalizacao;

    @Column(length = 500)
    private String observacoes;
}
