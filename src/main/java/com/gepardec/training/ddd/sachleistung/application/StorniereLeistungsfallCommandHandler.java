package com.gepardec.training.ddd.sachleistung.application;

import com.gepardec.training.ddd.sachleistung.domain.port.LeistungsfallRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.executable.ValidateOnExecution;

@ApplicationScoped
@Transactional
@ValidateOnExecution
public class StorniereLeistungsfallCommandHandler implements LeistungsfallStornieren {

    @Inject
    LeistungsfallRepository leistungsfallRepository;

    @Override
    public void stonieren(String nummer) {
        var leistungsfall = leistungsfallRepository.findeFuerId(nummer).orElseThrow(() -> new IllegalArgumentException("No Leistungsfall for stornieren"));
        leistungsfall.storniere();
        leistungsfallRepository.update(leistungsfall);
    }
}
