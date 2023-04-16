package com.scryfall.scryfallback.pages.set.repository;

import com.scryfall.scryfallback.pages.set.model.entity.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {
}
