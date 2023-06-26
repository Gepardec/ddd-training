package com.gepardec.training.ddd.sachleistung.domain.port;

import com.gepardec.training.ddd.sachleistung.domain.model.Leistungsfall;

import java.util.Optional;

public interface LeistungsfallRepository {

    Optional<Leistungsfall> findeFuerId(String id);

    void neu(Leistungsfall leistungsfall);

    void update(Leistungsfall leistungsfall);
}
