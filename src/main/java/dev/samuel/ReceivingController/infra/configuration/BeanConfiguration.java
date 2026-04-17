package dev.samuel.ReceivingController.infra.configuration;

import dev.samuel.ReceivingController.core.usecases.CadastrarRecebimentoCase;
import dev.samuel.ReceivingController.core.usecases.CadastrarRecebimentoCaseImpl;
import dev.samuel.ReceivingController.infra.gateway.ReceivingRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CadastrarRecebimentoCase createReceivingUseCase(ReceivingRepositoryGateway receivingRepositoryGateway) {
        return new CadastrarRecebimentoCaseImpl(receivingRepositoryGateway);
    }

}
