package com.exercise.pinapp.application;

import com.exercise.pinapp.dominio.ClientDto;
import com.exercise.pinapp.dominio.ClientRequest;
import com.exercise.pinapp.dominio.InfoClientDto;
import com.exercise.pinapp.infra.inputAdapter.inputPort.ClientInputPort;
import com.exercise.pinapp.mapper.ClientDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class ClientComponent implements ClientInputPort {

    @Autowired
    private ClientDtoMapper clientMapper;

    private List<ClientRequest> listClients = new ArrayList<>();

    @Override
    public void createClient(ClientRequest clientRequest) {
        if (isNull(clientRequest)) {
            log.error("Error al intentar crear el cliente");
        }
        listClients.add(clientRequest);
    }

    @Override
    public Mono<InfoClientDto> getInfoClient() {
        return Mono.just(calculateStandarDesviationAndMedia(this.listClients));
    }

    @Override
    public Mono<List<ClientDto>> getListClients() {
        return Mono.just(listClients.stream()
                .map(item -> clientMapper.map(item))
                .collect(Collectors.toList()));
    }

    private InfoClientDto calculateStandarDesviationAndMedia(List<ClientRequest> listClientes) {

        List<Integer> edades = listClientes.stream().map(item -> item.getEdad()).collect(Collectors.toList());
        float sumatoria = 0;
        double media = 0;
        double varianza = 0.0;

        for (int i = 0; i < listClientes.size(); i++ ){
            sumatoria = sumatoria + edades.get(i);
        }

        media = sumatoria / listClientes.size();

        for(int i = 0 ; i < listClientes.size(); i++){
            double rango;
            rango = Math.pow(edades.get(i) - media, 2);
            varianza = varianza + rango;
        }

        Double standar = Math.sqrt(varianza / listClientes.size());

        return InfoClientDto.builder()
                .promedioEdad(String.format("%.2f", media))
                .desviacionEstandar(String.format("%.2f",standar))
                .build();
    }
}
