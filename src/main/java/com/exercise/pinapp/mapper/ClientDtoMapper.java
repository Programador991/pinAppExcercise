package com.exercise.pinapp.mapper;

import com.exercise.pinapp.dominio.ClientDto;
import com.exercise.pinapp.dominio.ClientRequest;
import com.exercise.pinapp.dominio.constant.LifeExpectancy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class ClientDtoMapper {

    private static final Integer DEFAULT_OVER_LIFE = 1;

    public ClientDto map(ClientRequest clientRequest) {
        return new ClientDto(clientRequest.getNombre(),
                clientRequest.getApellido(), clientRequest.getEdad(),
                clientRequest.getFechaNacimiento(), calculateFechaMuerte(clientRequest
                .getEdad()));

    }
    private String calculateFechaMuerte(Integer clientAge) {

        LocalDate nowDate = LocalDate.now();
        Integer resultAge = LifeExpectancy.ARGENTINA.getLifeExpectancy() - clientAge;

        if(resultAge <= 0) {
            return String.format("Fecha probable de muerte: %s", applyFormatDate(nowDate.plusYears(DEFAULT_OVER_LIFE)));
        }

        return String.format("Fecha probable de muerte: %s", applyFormatDate(nowDate.plusYears(resultAge)));
    }

    private String applyFormatDate(LocalDate date) {
        try{
            return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(date);
        }catch (Exception ex) {
            log.error("Error durante calculo de fecha muerte.");
            return LocalDate.now().toString();
        }
    }
}
