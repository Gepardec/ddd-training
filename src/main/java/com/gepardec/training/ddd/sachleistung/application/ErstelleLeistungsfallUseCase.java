package com.gepardec.training.ddd.sachleistung.application;

import jakarta.validation.Valid;

public interface ErstelleLeistungsfallUseCase {

    void erstelle(@Valid ErstelleLeistungsfallCommand command);
}
