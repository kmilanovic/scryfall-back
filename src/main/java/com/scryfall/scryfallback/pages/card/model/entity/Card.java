package com.scryfall.scryfallback.pages.card.model.entity;

import com.scryfall.scryfallback.pages.set.model.entity.Set;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long card_id;

    @ManyToMany(mappedBy = "cards")
    private List<Set> sets;

    private String id;

    private String name;

    private String image_uri_normal;

    public List<Set> getSets() {
        if (sets == null) {
            sets = new ArrayList<>();
        }
        return sets;
    }
}
