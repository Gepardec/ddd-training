package com.gepardec.training.ddd.sachleistung.domain.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Gesamtleistung {

    @Size(min = 1, max = 50)
    private final String name;

    @NotEmpty
    private List<Einzelleistung> einzelleistungen = new LinkedList<>();

    public Gesamtleistung(String name) {
        this.name = Objects.requireNonNull(name, "Eine Gesamtleistung braucht einen Namen");
    }

    // TODO: Implementiere eine Factor Methode, welche eine Gesamtleistung mit Einzelleistungen erzeugt.

    // TODO: Implementiere eine Domänen Methode, welche die Summe der Einzelleistungen Nettobeträge liefert.
    // TODO: Implementiere eine Domänen Methode, die die Summe der Einzelleistungen Bruttobeträge liefert.
    // TODO: Implementiere eine Domänen Methode, die die Summe der Einzelleistungen MWST-Beträge liefert.


    public String getName() {
        return name;
    }

    public List<Einzelleistung> getEinzelleistungen() {
        return einzelleistungen;
    }
}
