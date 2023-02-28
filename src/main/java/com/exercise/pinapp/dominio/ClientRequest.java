package com.exercise.pinapp.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientRequest {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String fechaNacimiento;
}
