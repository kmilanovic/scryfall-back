package com.scryfall.scryfallback.shared.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RulingWrapper {
    private String object;
    private boolean hasMore;
    private List<Ruling> data;
}
