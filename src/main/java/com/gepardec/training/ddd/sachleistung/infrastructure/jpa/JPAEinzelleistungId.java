package com.gepardec.training.ddd.sachleistung.infrastructure.jpa;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JPAEinzelleistungId implements Serializable {

    @NotNull
    public String gesamtleistungName;

    @NotNull
    @Min(1)
    public Integer ordinal;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JPAEinzelleistungId that = (JPAEinzelleistungId) o;
        return Objects.equals(gesamtleistungName, that.gesamtleistungName) && Objects.equals(ordinal, that.ordinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gesamtleistungName, ordinal);
    }
}
