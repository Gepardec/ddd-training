package com.gepardec.training.ddd.sachleistung.application;

import com.gepardec.training.ddd.sachleistung.domain.model.Leistungsfall;
import jakarta.validation.Valid;

import java.util.Objects;

public class ErstelleLeistungsfallCommand {

    @Valid
    private final Leistungsfall leistungsfall;

    public ErstelleLeistungsfallCommand(Leistungsfall leistungsfall) {
        this.leistungsfall = Objects.requireNonNull(leistungsfall, "Leistungsfall");
    }

    public Leistungsfall getLeistungsfall() {
        return leistungsfall;
    }
}
