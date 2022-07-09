package br.com.cd2.sigabem.services;

import br.com.cd2.sigabem.dto.FreteDto;
import br.com.cd2.sigabem.model.Frete;
import br.com.cd2.sigabem.repository.FreteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FreteServiceTest {

    private FreteRepository repository;

    private FreteService service;
    private static final Long ID = 1L;

    private static final String nomeDestinatario = "Paulo";
    private static final String cepOrigem = "17067-650";
    private static final String cepDestino = "02722-170";
    private static final LocalDateTime dataPrevistaEntrega = LocalDateTime.now();
    private static final LocalDateTime dataConsulta = LocalDateTime.now();
    private static final Double peso = 10.0;
    private static final BigDecimal vlTotalFrete = BigDecimal.valueOf(peso*1);
    private Frete frete = new Frete(ID, nomeDestinatario, cepOrigem, cepDestino, dataPrevistaEntrega, dataConsulta, peso, vlTotalFrete);
    private FreteDto freteDto = new FreteDto(nomeDestinatario, cepOrigem, cepDestino, peso);

    @Test
    void whenCreateShouldSaveFrete(){
        when(repository.save(any())).thenReturn(frete);
        Frete response = service.create(freteDto);

        assertNotNull(response);
        assertEquals(Frete.class, response.getClass());
        assertEquals(nomeDestinatario, response.getNomeDestinatario());
        assertEquals(cepOrigem, response.getCepOrigem());
        assertEquals(cepDestino, response.getCepDestino());
        assertEquals(dataPrevistaEntrega, response.getDataPrevistaEntrega());
        assertEquals(dataConsulta, response.getDataConsulta());
        assertEquals(peso, response.getPeso());
        assertEquals(vlTotalFrete, response.getVlTotalFrete());
    }
    @Test
    void whenFindByIdShouldReturnUser() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(frete));
        Frete response = service.findById(ID);

        assertNotNull(response);
        assertEquals(Frete.class, response.getClass());
        assertEquals(nomeDestinatario, response.getNomeDestinatario());
        assertEquals(cepOrigem, response.getCepOrigem());
        assertEquals(cepDestino, response.getCepDestino());
        assertEquals(dataPrevistaEntrega, response.getDataPrevistaEntrega());
        assertEquals(dataConsulta, response.getDataConsulta());
        assertEquals(peso, response.getPeso());
        assertEquals(vlTotalFrete, response.getVlTotalFrete());
    }
}