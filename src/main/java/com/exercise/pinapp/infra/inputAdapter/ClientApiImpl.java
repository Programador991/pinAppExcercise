package com.exercise.pinapp.infra.inputAdapter;

import com.exercise.pinapp.dominio.ClientDto;
import com.exercise.pinapp.dominio.ClientRequest;
import com.exercise.pinapp.dominio.InfoClientDto;
import com.exercise.pinapp.infra.inputAdapter.inputPort.ClientInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ClientApiImpl implements ClientApi {

    @Autowired
    private ClientInputPort clientInputPort;

    @GetMapping("/status")
    public Mono<String> verStatus() {
        return Mono.just("ok");
    }

    @PostMapping("/creacliente")
    @Override
    public void createClient(ClientRequest clientRequest) {
        // TODO validacion de clientRequest
        clientInputPort.createClient(clientRequest);
    }

    @GetMapping("/kpidecliente")
    @Override
    public Mono<InfoClientDto> infoClient() {
        return clientInputPort.getInfoClient();
    }

    @GetMapping("/listclientes")
    @Override
    public Mono<List<ClientDto>> listClients() {
        return clientInputPort.getListClients();
    }
}
