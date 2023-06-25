package com.scryfall.scryfallback.pages.set.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scryfall.scryfallback.pages.card.model.entity.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "set")
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long set_id;

    private String object;
    private String id;
    private String code;
    private String name;
    private String tcgplayer_id;
    private String scryfall_uri;
    private String search_uri;
    private String released_at;
    private String set_type;
    private String card_count;
    private String digital;
    private String nonfoil_only;
    private String foil_only;
    private String icon_svg_uri;
    private Long user_id;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "card_set_list",
            joinColumns = @JoinColumn(name = "set_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<Card> cards;


}
