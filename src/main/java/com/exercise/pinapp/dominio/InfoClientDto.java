package com.exercise.pinapp.dominio;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class InfoClientDto {
    @JsonProperty("Promedio de edad")
    private String promedioEdad;
    @JsonProperty("Desviacion estandar")
    private String desviacionEstandar;
}
