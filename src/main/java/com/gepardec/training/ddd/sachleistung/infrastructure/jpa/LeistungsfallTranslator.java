package com.gepardec.training.ddd.sachleistung.infrastructure.jpa;

import com.gepardec.training.ddd.sachleistung.domain.model.Einzelleistung;
import com.gepardec.training.ddd.sachleistung.domain.model.Gesamtleistung;
import com.gepardec.training.ddd.sachleistung.domain.model.Leistungsfall;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class LeistungsfallTranslator {

    public Leistungsfall toLeistungsfall(JPALeistungsfall jpaLeistungsfall){
        return Leistungsfall.freierBuilder()
                .setVsnr(jpaLeistungsfall.vsnr)
                .setNummer(jpaLeistungsfall.nummer)
                .setStatus(jpaLeistungsfall.status)
                .setAbgelehntAm(jpaLeistungsfall.abgelehntAm)
                .setStorniertAm(jpaLeistungsfall.storniertAm)
                .setAblehnungGrund(jpaLeistungsfall.ablehnungGrund)
                .build();
    }

    private Gesamtleistung toGesamtleistung(JPAGesamtleistung jpaGesamtleistung) {
        var gesamtleistung = Gesamtleistung.neu(jpaGesamtleistung.name);
        var it = jpaGesamtleistung.einzelleistungen.iterator();
        int i = 0;
        while (it.hasNext()) {
            gesamtleistung.addEinzelleistung(toEinzelleistung(i, it.next()));
            i++;
        }
        return gesamtleistung;
    }

    private Einzelleistung toEinzelleistung(int ordinal, JPAEinzelleistung jpaEinzelleistung){
        return Einzelleistung.neu(ordinal, jpaEinzelleistung.name, jpaEinzelleistung.nettoBetrag, jpaEinzelleistung.mehrwertSteuer);
    }

    public JPALeistungsfall toJPALeistungsfall(final Leistungsfall leistungsfall){
        var jpaGesamtleistung = toJPAGesamtleistung(leistungsfall.getGesamtleistung());
        var jpaLeistungsfall = new JPALeistungsfall();
        jpaLeistungsfall.nummer = leistungsfall.getNummer();
        jpaLeistungsfall.vsnr = leistungsfall.getVsnr();
        jpaLeistungsfall.status = leistungsfall.getStatus();
        jpaLeistungsfall.ablehnungGrund = leistungsfall.getAblehnungGrund();
        jpaLeistungsfall.storniertAm = leistungsfall.getStorniertAm();
        jpaLeistungsfall.abgelehntAm = leistungsfall.getAbgelehntAm();
        jpaLeistungsfall.angewiesenAm = leistungsfall.getAngewiesenAm();
        jpaLeistungsfall.gesamtleistung = jpaGesamtleistung;
        jpaLeistungsfall.gesamtleistung.leistungsfall = jpaLeistungsfall;

        return jpaLeistungsfall;
    }

    private JPAGesamtleistung toJPAGesamtleistung(final Gesamtleistung gesamtleistung){
        var jpaEinzelleistungen = toJPAEinzelleistungen(gesamtleistung.getEinzelleistungen());
        var jpaGesamtleistung = new JPAGesamtleistung();
        jpaGesamtleistung.name = gesamtleistung.getName();
        jpaGesamtleistung.einzelleistungen = jpaEinzelleistungen;

        return jpaGesamtleistung;
    }

    private Set<JPAEinzelleistung> toJPAEinzelleistungen(final List<Einzelleistung> einzelleistungen){
       return einzelleistungen.stream().map(this::toJPAEinzelleistung).collect(Collectors.toSet());
    }

    private JPAEinzelleistung toJPAEinzelleistung(final Einzelleistung einzelleistung){
        var jpaEinzelleistung = new JPAEinzelleistung();
        jpaEinzelleistung.name = einzelleistung.getName();
        jpaEinzelleistung.bruttoBetrag = einzelleistung.getBruttoBetrag();
        jpaEinzelleistung.nettoBetrag = einzelleistung.getNettoBetrag();
        jpaEinzelleistung.mehrwertSteuer = einzelleistung.getMehrwertSteuer();

        return jpaEinzelleistung;
    }
}
