package com.gepardec.training.ddd.sachleistung.infrastructure.jpa;

import com.gepardec.training.ddd.sachleistung.domain.model.Status;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "leistungsfall")
public class JPALeistungsfall extends PanacheEntityBase {

    @NotNull
    @Size(min = 1, max = 50)
    @Id
    public String nummer;

    @NotNull
    @Enumerated(EnumType.STRING)
    public Status status;

    @NotNull
    @Size(min = 5, max = 255)
    public String ablehnungGrund;

    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime angewiesenAm;

    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime storniertAm;

    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime abgelehntAm;

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
