package com.exercise.pinapp.infra.inputAdapter;

import com.exercise.pinapp.dominio.ClientDto;
import com.exercise.pinapp.dominio.ClientRequest;
import com.exercise.pinapp.dominio.InfoClientDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ClientApi {
    void createClient(ClientRequest clientRequest);
    Mono<InfoClientDto> infoClient();
    Mono<List<ClientDto>> listClients();
}
