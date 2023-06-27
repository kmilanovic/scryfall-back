package com.scryfall.scryfallback.shared.model.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveCardInSetCommand {
    private String cardId;
    private Long setId;
    private String cardName;
    private String imageUriNormal;
}
