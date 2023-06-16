package com.gepardec.training.ddd.sachleistung.infrastructure.jpa;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Gesamtleistung")
public class JPAGesamtleistung extends PanacheEntityBase  {

    @Id
    public String leistungsfallNummer;

    @NotNull
    @Size(min = 1, max = 50)
    public String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    public LocalDateTime erstelltAm;

    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime modifiziertAm;

    @ElementCollection
    public Set<JPAEinzelleistung> einzelleistungen = new HashSet<>(0);

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    public JPALeistungsfall leistungsfall;

    @PrePersist
    private void onPersist(){
        erstelltAm = modifiziertAm = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate(){
        modifiziertAm = LocalDateTime.now();
    }
}
