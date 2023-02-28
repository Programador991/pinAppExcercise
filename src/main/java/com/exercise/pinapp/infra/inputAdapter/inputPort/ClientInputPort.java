package com.exercise.pinapp.infra.inputAdapter.inputPort;

import com.exercise.pinapp.dominio.ClientDto;
import com.exercise.pinapp.dominio.ClientRequest;
import com.exercise.pinapp.dominio.InfoClientDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ClientInputPort {
    void createClient(ClientRequest clientRequest);
    Mono<InfoClientDto> getInfoClient();
    Mono<List<ClientDto>> getListClients();
}
