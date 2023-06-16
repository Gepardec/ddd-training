package com.gepardec.training.ddd.sachleistung.infrastructure.jpa;

import com.gepardec.training.ddd.sachleistung.domain.model.Leistungsfall;
import com.gepardec.training.ddd.sachleistung.domain.port.LeistungsfallRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class JPALeistungsfallRepository implements LeistungsfallRepository {

    @Inject
    EntityManager em;

    @Inject
    LeistungsfallTranslator leistungsfallTranslator;

    @Override
    public void neu(Leistungsfall leistungsfall) {
        var jpaLeistungsfall = leistungsfallTranslator.toJPALeistungsfall(leistungsfall);
        em.persist(jpaLeistungsfall);
    }
}
