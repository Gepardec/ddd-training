package com.gepardec.training.ddd.sachleistung.application;

import com.gepardec.training.ddd.sachleistung.domain.model.Einzelleistung;
import com.gepardec.training.ddd.sachleistung.domain.model.Gesamtleistung;
import com.gepardec.training.ddd.sachleistung.domain.model.Leistungsfall;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@QuarkusTest
class ErstelleLeistungsfallUseCaseTest {

    @Inject
    ErstelleLeistungsfallUseCase useCase;

    @Test
    void test(){
        var einzelleistung = Einzelleistung.neu(1, "eins", BigDecimal.TEN, BigDecimal.TEN);
        var gesamtleistung = Gesamtleistung.neu("name");
        gesamtleistung.addEinzelleistung(einzelleistung);
        var leistungsfall = Leistungsfall.neu("L1000", "2216150381", gesamtleistung);
        useCase.erstelle(new ErstelleLeistungsfallCommand(leistungsfall));
    }
}
