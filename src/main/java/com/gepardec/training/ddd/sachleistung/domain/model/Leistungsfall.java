package com.gepardec.training.ddd.sachleistung.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

public class Leistungsfall {

    @NotBlank
    @Size(min = 1, max = 50)
    private final String nummer;

    @NotNull
    private Status status;

    @Size(min = 5, max = 255)
    private String ablehnungGrund;

    private LocalDateTime angewiesenAm;

    private LocalDateTime storniertAm;

    private LocalDateTime abgelehntAm;

    private Leistungsfall(String nummer) {
        this.nummer = Objects.requireNonNull(nummer, "Ein Leistungsfall muss eine Id haben");
    }

    // Factory Methode, die einen korrekt initialisierten Leistungsfall erzeugt.
    public static Leistungsfall neu(final String id) {
        var fall = new Leistungsfall(id);
        fall.status = Status.NEU;
        return fall;
    }

    // HINT: Die Domänen aktionen dürfen nicht ein zweites Mal ausgeführt werden, was am Status zu erkennen ist!
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall zur Anweisung freigibt
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall anweist
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall storniert
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall mit einer Begründung ablehnt

    // Getter/Setter
    public String getNummer() {
        return nummer;
    }

    public Status getStatus() {
        return status;
    }

    public String getAblehnungGrund() {
        return ablehnungGrund;
    }

    public LocalDateTime getAngewiesenAm() {
        return angewiesenAm;
    }

    public LocalDateTime getStorniertAm() {
        return storniertAm;
    }

    public LocalDateTime getAbgelehntAm() {
        return abgelehntAm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leistungsfall that = (Leistungsfall) o;
        return Objects.equals(nummer, that.nummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nummer);
    }
}
