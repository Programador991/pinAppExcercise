package com.exercise.pinapp.mapper;

import com.exercise.pinapp.dominio.ClientDto;
import com.exercise.pinapp.dominio.ClientRequest;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoMapper {

    public ClientDto map(ClientRequest clientRequest) {
        return new ClientDto(clientRequest.getNombre(),
                clientRequest.getApellido(), clientRequest.getEdad(),
                clientRequest.getFechaNacimiento(), calculateFechaMuerte());

    }
    private String calculateFechaMuerte() {
        return "Todo el calculo";
    }
}
