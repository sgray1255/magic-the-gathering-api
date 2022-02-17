package com.MTGAPI.magic.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository
        extends JpaRepository<Card, Long> {

    Optional<Card> findById(Long Id);

}
