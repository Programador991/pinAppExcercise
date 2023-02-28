package com.exercise.pinapp.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto extends ClientRequest {
    private String fechaMuerte;

    public ClientDto(String nombre, String apellido, Integer edad,
                     String fechaNacimiento, String fechaMuerte) {
        super(nombre, apellido, edad, fechaNacimiento);
        this.fechaMuerte = fechaMuerte;
    }
}
