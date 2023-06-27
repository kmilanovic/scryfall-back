package com.scryfall.scryfallback.shared.model.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageCommand {
    private int pageIndex;
    private int pageSize;
    private int total;
}
