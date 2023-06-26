package com.gepardec.training.ddd.sachleistung.infrastructure.jpa;

import com.gepardec.training.ddd.sachleistung.domain.model.Leistungsfall;
import com.gepardec.training.ddd.sachleistung.domain.port.LeistungsfallRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.Optional;

@ApplicationScoped
public class JPALeistungsfallRepository implements LeistungsfallRepository {

    @Inject
    EntityManager em;

    @Inject
    LeistungsfallTranslator leistungsfallTranslator;

    @Override
    public Optional<Leistungsfall> findeFuerId(String id) {
        var jpaEntity = JPALeistungsfall.<JPALeistungsfall>findById(id);
        return (jpaEntity == null) ? Optional.empty() :  Optional.of(leistungsfallTranslator.toLeistungsfall(jpaEntity));
    }

    @Override
    public void neu(Leistungsfall leistungsfall) {
        var jpaLeistungsfall = leistungsfallTranslator.toJPALeistungsfall(leistungsfall);
        em.persist(jpaLeistungsfall);
    }

    @Override
    public void update(Leistungsfall leistungsfall) {
        var jpaLeistungsfall = leistungsfallTranslator.toJPALeistungsfall(leistungsfall);
        em.merge(jpaLeistungsfall);
    }
}
