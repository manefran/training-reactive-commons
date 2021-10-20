package com.sofka.training;

import com.sofka.training.domain.usecase.ConfirmCreatePetUseCase;
import com.sofka.training.domain.usecase.CreatePetUseCase;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDomainEventBus
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CreatePetUseCase createPetUseCase(DomainEventBus eventBus) {
        return new CreatePetUseCase(eventBus);
    }

    @Bean
    public ConfirmCreatePetUseCase confirCreatePetUseCase() { return new ConfirmCreatePetUseCase(); }

}
