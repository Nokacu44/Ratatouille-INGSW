package com.ratatouille.Ratatouille23.allergen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class AllergenRepositoryTest {

    @Autowired
    private AllergenRepository underTest;


    @Test
    void itShouldFindAllergenByName() {
        // give
        String name = "Sodio";
        Allergen allergen = new Allergen(
                name,
                new ArrayList<>()
        );
        underTest.save(allergen);

        // when
        Optional<Allergen> allergenByName = underTest.findByName(name);

        assertThat(
                allergenByName.isPresent()
        ).isTrue();

        assertThat(
                allergenByName.get().getId().equals(allergen.getId())
        ).isTrue();
    }
}