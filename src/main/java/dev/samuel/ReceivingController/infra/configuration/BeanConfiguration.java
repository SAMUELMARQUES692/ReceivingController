package dev.samuel.ReceivingController.infra.configuration;

import dev.samuel.ReceivingController.core.gateway.ReceivingGateway;
import dev.samuel.ReceivingController.core.usecases.BuscarRecebimentoCase;
import dev.samuel.ReceivingController.core.usecases.BuscarRecebimentoCaseImpl;
import dev.samuel.ReceivingController.core.usecases.CadastrarRecebimentoCase;
import dev.samuel.ReceivingController.core.usecases.CadastrarRecebimentoCaseImpl;
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

}
