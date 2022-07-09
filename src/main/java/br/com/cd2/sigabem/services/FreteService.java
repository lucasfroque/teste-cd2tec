package br.com.cd2.sigabem.services;

import br.com.cd2.sigabem.dto.FreteDto;
import br.com.cd2.sigabem.model.Frete;
import br.com.cd2.sigabem.repository.FreteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class FreteService {

    private FreteRepository repository;

    public Frete create(FreteDto freteDto){
        Frete frete = new Frete();
        frete.setCepDestino(freteDto.getCepDestino());
        frete.setCepOrigem(freteDto.getCepOrigem());
        frete.setNomeDestinatario(freteDto.getNomeDestinatario());
        frete.setPeso(freteDto.getPeso());
        frete.setVlTotalFrete(calcFrete(freteDto.getCepDestino(), freteDto.getCepOrigem(), freteDto.getPeso()));
        repository.save(frete);

        return frete;
    }

    public Frete findById(Long id) {
        Optional<Frete> obj = repository.findById(id);

        return obj.orElseThrow(RuntimeException::new);
    }

    public BigDecimal calcFrete(String cepDestino, String cepOrigem, Double peso){
        Double taxPerKg = 1.0;

        BigDecimal vlTotalFrete = BigDecimal.valueOf((peso * taxPerKg));

        return vlTotalFrete;
    }
}
