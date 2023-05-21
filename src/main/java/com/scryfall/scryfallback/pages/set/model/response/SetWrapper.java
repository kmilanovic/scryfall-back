package com.scryfall.scryfallback.pages.set.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SetWrapper {
    private String object;
    private boolean has_more;
    private List<Set> data;
}
