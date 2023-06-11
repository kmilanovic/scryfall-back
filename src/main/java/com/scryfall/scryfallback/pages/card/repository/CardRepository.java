package com.scryfall.scryfallback.pages.card.repository;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card save(Card card);

}
