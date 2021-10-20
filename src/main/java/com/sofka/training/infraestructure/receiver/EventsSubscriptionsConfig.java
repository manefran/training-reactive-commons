package com.sofka.training.infraestructure.receiver;

import com.sofka.training.domain.model.Pet;
import com.sofka.training.domain.usecase.ConfirmCreatePetUseCase;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.reactivecommons.async.api.HandlerRegistry.register;

@Configuration
@EnableMessageListeners
@RequiredArgsConstructor
public class EventsSubscriptionsConfig {

    private final ConfirmCreatePetUseCase useCase;
    private final String eventName = "pet.created";

    @Bean
    public HandlerRegistry eventSubscriptions() {
        return register()
                .listenEvent(eventName, event -> useCase.confirmCreatePet(event), Pet.class);
    }

}
