package com.gepardec.training.ddd.sachleistung.application;

import com.gepardec.training.ddd.sachleistung.domain.port.LeistungsfallRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ErstelleLeistungsfallCommandHandler implements ErstelleLeistungsfallUseCase {

    @Inject
    LeistungsfallRepository leistungsfallRepository;

    // TODO: Implementiere und benutze einen Validator, der prüft ob. 1. Nummer schon vergeben ist

    @Override
    public void erstelle(ErstelleLeistungsfallCommand command) {
        leistungsfallRepository.neu(command.getLeistungsfall());
    }
}
