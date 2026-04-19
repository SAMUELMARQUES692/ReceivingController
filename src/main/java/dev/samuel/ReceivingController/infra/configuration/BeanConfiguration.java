package dev.samuel.ReceivingController.infra.configuration;

import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;
import dev.samuel.ReceivingController.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CadastrarRecebimentoCase createReceivingUseCase(ReceivingGateway receivingGateway) {
        return new CadastrarRecebimentoCaseImpl(receivingGateway);
    }

    @Bean
    public BuscarRecebimentoCase findReceivingUseCase(ReceivingGateway receivingGateway) {
        return new BuscarRecebimentoCaseImpl(receivingGateway);
    }

    @Bean
    public BuscarRecebimentoPorIdCase findReceivingIdUseCase(ReceivingGateway receivingGateway) {
        return new BuscarRecebimentoPorIdImpl(receivingGateway);
    }

    @Bean
    public AtualizarRecebimentoCase updateReceivingIdUseCase(ReceivingGateway receivingGateway) {
        return new AtualizarRecebimentoCaseImpl(receivingGateway);
    }

    @Bean
    public DeletarRecebimentoCase deleteReceivingIdUseCase(ReceivingGateway receivingGateway) {
        return new DeletarRecebimentoCaseImpl(receivingGateway);
    }

}
