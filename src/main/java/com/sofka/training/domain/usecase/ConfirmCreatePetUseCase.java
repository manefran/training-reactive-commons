package com.sofka.training.domain.usecase;

import com.sofka.training.domain.model.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import reactor.core.publisher.Mono;

@Log
public class ConfirmCreatePetUseCase {

    public Mono<Void> confirmCreatePet(DomainEvent<Pet> event){
        log.info(String.format("Recibiendo evento de dominio: %s: %s", event.getName(), event.getData().toString()));
        return Mono.empty();
    }

}
