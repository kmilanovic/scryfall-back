package com.scryfall.scryfallback.pages.card.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardRequest {
    private String id;
    private String multiverseId;
    private String mtgoId;
}
