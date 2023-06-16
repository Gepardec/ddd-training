package com.gepardec.training.ddd.sachleistung.domain.port;

import com.gepardec.training.ddd.sachleistung.domain.model.Leistungsfall;

public interface LeistungsfallRepository {

    void neu(Leistungsfall leistungsfall);
}
