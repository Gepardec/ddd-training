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


    private Leistungsfall(Builder builder) {
        this.nummer = Objects.requireNonNull(builder.nummer, "Ein Leistungsfall muss eine Id haben");
        this.vsnr = Objects.requireNonNull(builder.vsnr, "Ein Leistungsfall muss einer VSNR zugeordnet sein");
        this.status = Objects.requireNonNull(builder.status, "Ein Leistungsfall muss einen Status");
        this.gesamtleistung = Objects.requireNonNull(builder.gesamtleistung, "Ein Leistungsfall muss eine Gesamtleistung haben");
        this.ablehnungGrund = builder.ablehnungGrund;
        this.angewiesenAm = builder.angewiesenAm;
        this.storniertAm = builder.storniertAm;
        this.abgelehntAm = builder.abgelehntAm;
    }

    public static Leistungsfall.Builder freierBuilder(){
        return new Builder();
    }
    // Factory Methode, die einen korrekt initialisierten Leistungsfall erzeugt.
    public static Leistungsfall neu(final String nummer, final String vsnr, final Gesamtleistung gesamtleistung) {
        return freierBuilder().setNummer(nummer).setVsnr(vsnr).setStatus(Status.NEU).setGesamtleistung(gesamtleistung).build();
    }

    // HINT: Remind the business rules in the README.adoc!
    public void storniere(){
        if(!Status.NEU.equals(status) && !Status.ANWEISUNG_FREIGEGEBEN.equals(status)){
            throw new IllegalStateException("Leistungsfall cannot be storniert because neither NEU nor ANWEISUNG_FREIGEGEBEN");
        }
        status = Status.STORNIERT;
        storniertAm = LocalDateTime.now();
    }

    public void zurAnweisungFreigeben(){
        if(!Status.NEU.equals(status)){
            throw new IllegalStateException("Leistungsfall anweisen not possible because not NEU");
        }
        status = Status.ANWEISUNG_FREIGEGEBEN;
    }


    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall zur Anweisung freigibt
    // TODO: Implementiere eine Domänen Methode, die den Leistungsfall anweist
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

    public static class Builder {
        private String nummer;
        private String vsnr;
        private Gesamtleistung gesamtleistung;
        private Status status;
        private String ablehnungGrund;
        private LocalDateTime angewiesenAm;
        private LocalDateTime storniertAm;
        private LocalDateTime abgelehntAm;

        public Builder setNummer(String nummer) {
            this.nummer = nummer;
            return this;
        }

        public Builder setVsnr(String vsnr) {
            this.vsnr = vsnr;
            return this;
        }

        public Builder setGesamtleistung(Gesamtleistung gesamtleistung) {
            this.gesamtleistung = gesamtleistung;
            return this;
        }

        public Builder setStatus(@NotNull Status status) {
            this.status = status;
            return this;
        }

        public Builder setAblehnungGrund(String ablehnungGrund) {
            this.ablehnungGrund = ablehnungGrund;
            return this;
        }

        public Builder setAngewiesenAm(LocalDateTime angewiesenAm) {
            this.angewiesenAm = angewiesenAm;
            return this;
        }

        public Builder setStorniertAm(LocalDateTime storniertAm) {
            this.storniertAm = storniertAm;
            return this;
        }

        public Builder setAbgelehntAm(LocalDateTime abgelehntAm) {
            this.abgelehntAm = abgelehntAm;
            return this;
        }

        public Leistungsfall build() {
            return new Leistungsfall(this);
        }
    }
}
