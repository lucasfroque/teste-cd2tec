package br.com.cd2.sigabem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Frete implements Serializable {
    private final long serialVersionUID = 1L;

    private Long id;
    private String nomeDestinatario;
    private String cepOrigem;
    private String cepDestino;
    private LocalDateTime dataPrevistaEntrega;
    private LocalDateTime dataConsulta;
    private Double peso;
    private BigDecimal vlTotalFrete;
}
