package com.gepardec.training.ddd.sachleistung.domain.model;

import jakarta.validation.constraints.Size;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Gesamtleistung {

    @Size(min = 1, max = 50)
    private final String name;

    @Size(min = 1)
    private List<Einzelleistung> einzelleistungen = new LinkedList<>();

    public Gesamtleistung(String name) {
        this.name = Objects.requireNonNull(name, "Eine Gesamtleistung braucht einen Namen");
    }

    public static Gesamtleistung neu(String name) {
        return new Gesamtleistung(name);
    }

    public void addEinzelleistung(final Einzelleistung einzelleistung) {
        Objects.requireNonNull(einzelleistung, "Null Einzelleistung kann nicht hinzugefügt werden");
        // TODO: Validate constraints here
        einzelleistungen.add(einzelleistung);
    }

    public String getName() {
        return name;
    }

    public List<Einzelleistung> getEinzelleistungen() {
        return einzelleistungen;
    }
}
