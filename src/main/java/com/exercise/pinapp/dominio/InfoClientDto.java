package com.exercise.pinapp.dominio;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class InfoClientDto {
    private String promedioEdad;
    private String desviacionEstandar;
}
