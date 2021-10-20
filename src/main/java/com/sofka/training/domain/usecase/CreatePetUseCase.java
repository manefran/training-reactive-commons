package com.sofka.training.domain.usecase;

import com.sofka.training.domain.model.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Log
@RequiredArgsConstructor
public class CreatePetUseCase {
    private final DomainEventBus eventBus;
    private final String eventName = "pet.created";

    public Mono<Pet> createNewPet(String name, String type){
        return Mono.fromSupplier(() -> UUID.randomUUID().toString())
                .map(id -> new Pet(id,name,type))
                .flatMap(pet -> emitCreatedEvent(pet).thenReturn(pet));

    }

    private Mono<Void> emitCreatedEvent(Pet pet) {
        log.info(String.format("Emitiendo evento de dominio: %s: %s", "pet.created", pet.toString()));
        return Mono.from(eventBus.emit(new DomainEvent<>(eventName, pet.getId(), pet)));
    }

}
