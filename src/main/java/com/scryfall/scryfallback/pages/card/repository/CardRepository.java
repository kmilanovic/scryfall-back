package com.scryfall.scryfallback.pages.card.repository;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card save(Card card);

    @Query("SELECT c FROM Card c JOIN c.sets s WHERE s.set_id = :setId")
    Page<Card> findCardsBySetId(@Param("setId") Long setId, Pageable pageable);
}
