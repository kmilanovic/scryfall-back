package com.scryfall.scryfallback.pages.card.service;

import com.scryfall.scryfallback.pages.card.model.response.Card;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.shared.ScryfallHandler;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CardServiceImpl implements CardService {
    private final ScryfallHandler scryfallHandler;

    public CardServiceImpl(ScryfallHandler scryfallHandler) {
        this.scryfallHandler = scryfallHandler;
    }


    @Override
    public Card getCardById(Card card) {
        return scryfallHandler.getCardById(card);
    }

    @Override
    public RulingWrapper getCardRulings(Card card) {
        return scryfallHandler.getCardRulings(card);
    }

    @Override
    public CardWrapper getCardsBySearch(SearchTerm searchTerm) {
        return scryfallHandler.getCardsBySearch(searchTerm);
    }
}
