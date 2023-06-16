package com.gepardec.training.ddd.sachleistung.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

public class Leistungsfall {

    @Size(min = 1, max = 50)
    private final String nummer;

    @Size(min = 10, max = 10)
    private final String vsnr;

    private final Gesamtleistung gesamtleistung;

    @NotNull
    private Status status;

    @Size(max = 255)
    private String ablehnungGrund;

    private LocalDateTime angewiesenAm;

    private LocalDateTime storniertAm;

    private LocalDateTime abgelehntAm;

    // TODO: Implementiere Domänen Events

    private Leistungsfall(final String nummer, final String vsnr, final Status status, final Gesamtleistung gesamtleistung) {
        this.nummer = Objects.requireNonNull(nummer, "Ein Leistungsfall muss eine Id haben");
        this.vsnr = Objects.requireNonNull(vsnr, "Ein Leistungsfall muss einer VSNR zugeordnet sein");
        this.status = Objects.requireNonNull(status, "Ein Leistungsfall muss einen Status");
        this.gesamtleistung = Objects.requireNonNull(gesamtleistung, "Ein Leistungsfall muss eine Gesamtleistung haben");
    }

    // Factory Methode, die einen korrekt initialisierten Leistungsfall erzeugt.
    public static Leistungsfall neu(final String nummer, final String vsnr, final Gesamtleistung gesamtleistung) {
        return new Leistungsfall(nummer, vsnr, Status.NEU, gesamtleistung);
    }

    // HINT: Remind the business rules in the README.adoc!
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall zur Anweisung freigibt
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall anweist
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall storniert
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall mit einer Begründung ablehnt

    // Getter/Setter
    public String getNummer() {
        return nummer;
    }

    public String getVsnr() {
        return vsnr;
    }

    public Gesamtleistung getGesamtleistung() {
        return gesamtleistung;
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
