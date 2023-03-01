package com.exercise.pinapp.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientRequest {
    @JsonProperty("Nombre")
    private String nombre;
    @JsonProperty("Apellido")
    private String apellido;
    @JsonProperty("Edad")
    private Integer edad;
    @JsonProperty("Fecha de nacimiento")
    private String fechaNacimiento;
}
