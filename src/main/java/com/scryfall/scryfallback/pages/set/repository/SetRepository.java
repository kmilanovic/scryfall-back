package com.scryfall.scryfallback.pages.set.repository;

import com.scryfall.scryfallback.pages.set.model.entity.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {
    Set save(Set set);

    @Query("SELECT s FROM Set s WHERE s.user_id = :userId")
    List<Set> findAllByUserId(Long userId);
}
