package com.scryfall.scryfallback.pages.card.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CardWrapper {
    private String object;
    private Integer total_cards;
    private boolean has_more;
    private String next_page;
    private List<CardResponse> data;
}
