package com.gepardec.training.ddd.sachleistung.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class LeistungsfallTest {

    @Nested
    class GesamtleistungTest {

    }

    @Nested
    class EinzelleistungTest {

    }

    @Nested
    class DomaenenMethodenTest {

        @Nested
        class StorniereTest {

            @Test
            void throwsIllegalStateException_whenAlreadyStorniert(){
                var leistungsfall = createValidBuilder().setStorniertAm(LocalDateTime.now()).build();

                Assertions.assertThrows(IllegalStateException.class, leistungsfall::storniere);
            }
        }
    }

    private Leistungsfall.Builder createValidBuilder(){
        return Leistungsfall.freierBuilder();
    }
}
