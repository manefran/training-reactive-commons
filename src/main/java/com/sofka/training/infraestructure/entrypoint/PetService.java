package com.sofka.training.infraestructure.entrypoint;

import com.sofka.training.domain.model.Pet;
import com.sofka.training.domain.usecase.CreatePetUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log
@RestController
@RequiredArgsConstructor
public class PetService {

    private final CreatePetUseCase useCase;

    @PostMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Pet> createNew(@RequestBody PetDTO pet){
        return useCase.createNewPet(pet.getName(),pet.getType());
    }
}
