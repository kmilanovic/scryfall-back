package com.scryfall.scryfallback.pages.set.model.command;

import lombok.Data;

@Data
public class SetAddCommand {
    private String name;
    private Long userId;
}
