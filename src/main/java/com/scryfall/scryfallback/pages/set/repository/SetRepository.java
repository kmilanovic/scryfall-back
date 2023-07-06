package com.scryfall.scryfallback.pages.set.repository;

import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.model.entity.SetIcon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {
    Set save(Set set);

    @Query("SELECT s FROM Set s WHERE s.user_id = :userId")
    Page<Set> findAllByUserId(Long userId, Pageable pageable);

    @Query("SELECT s FROM Set s WHERE s.user_id = :userId")
    List<Set> findAllByUserId(Long userId);

    @Query("SELECT si FROM SetIcon si")
    List<SetIcon> findAllIcons();

    void deleteById(Long id);
}
