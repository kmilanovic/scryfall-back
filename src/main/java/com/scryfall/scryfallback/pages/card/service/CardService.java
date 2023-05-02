package com.scryfall.scryfallback.pages.card.service;

import com.scryfall.scryfallback.pages.card.model.response.Card;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;

public interface CardService {

    Card getCardById(Card card);

    RulingWrapper getCardRulings(Card card);

    CardWrapper getCardsBySearch(SearchTerm searchTerm);
}
