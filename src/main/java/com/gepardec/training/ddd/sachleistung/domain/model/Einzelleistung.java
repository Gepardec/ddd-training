package com.gepardec.training.ddd.sachleistung.domain.model;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Einzelleistung {

    @Min(1)
    private final int ordinal;

    @Size(min = 1, max = 100)
    private final String name;

    @NotNull
    @DecimalMin("0.00")
    private final BigDecimal nettoBetrag;

    @DecimalMin("0.00")
    private final BigDecimal mehrwertSteuer;

    @NotNull
    @DecimalMin("0.00")
    private final BigDecimal bruttoBetrag;

    public Einzelleistung(int ordinal, String name, BigDecimal nettoBetrag, BigDecimal mehrwertSteuer) {
        this.ordinal = ordinal;
        this.name = Objects.requireNonNull(name, "Eine Einzelleistung braucht einen Namen");
        this.nettoBetrag = Objects.requireNonNull(nettoBetrag, "Eine Einzelleistung braucht einen Nettobetrag");
        this.mehrwertSteuer = mehrwertSteuer;
        if (this.mehrwertSteuer != null && BigDecimal.ZERO.compareTo(mehrwertSteuer) == 0) {
            this.bruttoBetrag = this.nettoBetrag.add(nettoBetrag.multiply(mehrwertSteuer).divide(new BigDecimal("100.00"), RoundingMode.HALF_EVEN));
        } else {
            this.bruttoBetrag = this.nettoBetrag;
        }
    }

    public static Einzelleistung neu(int ordinal, String name, BigDecimal nettoBetrag, BigDecimal mehrwertSteuer) {
        return new Einzelleistung(ordinal, name, nettoBetrag, Objects.requireNonNull(mehrwertSteuer, "Eine normale Einzelleistung braucht eine MehrwertSteuer"));
    }

    // TODO: Implementiere eine Factory Methode, die eine leere Einzeleistung erzeugt.
    // TODO: Implementiere eine Factory Methode, die eine MWST-befreite Einzeleistung erzeugt.

    public int getOrdinal() {
        return ordinal;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNettoBetrag() {
        return nettoBetrag;
    }

    public BigDecimal getMehrwertSteuer() {
        return mehrwertSteuer;
    }

    public BigDecimal getBruttoBetrag() {
        return bruttoBetrag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Einzelleistung that = (Einzelleistung) o;
        return ordinal == that.ordinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordinal);
    }
}
