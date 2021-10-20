package com.sofka.training.infraestructure.entrypoint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetDTO {
    private String name;
    private String type;
}
