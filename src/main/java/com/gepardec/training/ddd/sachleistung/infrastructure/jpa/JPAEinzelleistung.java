package com.gepardec.training.ddd.sachleistung.infrastructure.jpa;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "einzelleistung")
public class JPAEinzelleistung extends PanacheEntityBase  {


    @NotNull
    @EmbeddedId
    public JPAEinzelleistungId id;

    @NotNull
    @Size(min = 1, max = 100)
    public String name;

    @NotNull
    @Column(scale = 2)
    public BigDecimal nettoBetrag;

    @Column(scale = 2)
    public BigDecimal mehrwertSteuer;

    @NotNull
    @Column(scale = 2)
    public BigDecimal bruttoBetrag;

    @ManyToOne
    @JoinColumn(name = "gesamtleistung_id")
    public JPAGesamtleistung gesamtleistung;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    public LocalDateTime erstelltAm;

    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime modifiziertAm;

    @PrePersist
    private void onPersist(){
        erstelltAm = modifiziertAm = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate(){
        modifiziertAm = LocalDateTime.now();
    }
}
