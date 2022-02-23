package com.MTGAPI.magic.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository
        extends JpaRepository<Card, Long> {

    Optional<Card> findById(Long Id);

//    id=" + id +
//            ", name='" + name + '\'' +
//            ", cmc=" + cmc +
//            ", mana_type='" + mana_type + '\'' +
//            ", type_line='" + type_line + '\'' +
//            ", expansion='" + expansion + '\'' +
//            ", power=" + power +
//            ", toughness=" + toughness +
////                ", text=" + text +
//            '}';

    @Modifying
    @Query(value = "SELECT FROM cards c" + "WHERE" +
            "c.name LIKE %:searchString " +
            "OR c.cmc LIKE %searchString " +
            "OR c.mana_type LIKE %searchString " +
            "OR c.type_line LIKE %searchString " +
            "OR c.expansion LIKE %searchString ",
            nativeQuery = true)
    List<Card> getQueryMatch(@Param(value = "searchString") String searchString);

}
