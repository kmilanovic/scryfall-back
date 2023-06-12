package com.scryfall.scryfallback.pages.card.service;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.card.model.response.CardResponse;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.pages.set.model.response.SetResponse;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import com.scryfall.scryfallback.shared.model.command.ByIdCommand;
import com.scryfall.scryfallback.shared.model.command.SaveCardInSetCommand;

import java.util.List;

public interface CardService {

    CardResponse getCardById(CardResponse cardResponse);

    RulingWrapper getCardRulings(CardResponse cardResponse);

    CardWrapper getCardsBySearch(SearchTerm searchTerm);

    CardWrapper getCardsBySetCode(SetResponse setResponse);

    void saveCardInSet(SaveCardInSetCommand command);

    List<Card> getCardsBySet(ByIdCommand command);
}
