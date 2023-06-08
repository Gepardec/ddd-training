package com.gepardec.training.ddd.sachleistung.domain.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Gesamtleistung {

    private final String name;

    private List<Einzelleistung> einzelleistungen = new LinkedList<>();

    public Gesamtleistung(String name) {
        this.name = Objects.requireNonNull(name, "Eine Gesamtleistung braucht einen Namen");
    }
}
