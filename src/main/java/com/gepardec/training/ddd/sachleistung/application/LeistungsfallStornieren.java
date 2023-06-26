package com.gepardec.training.ddd.sachleistung.application;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public interface LeistungsfallStornieren {

    void stonieren(@NotBlank String nummer);
}
