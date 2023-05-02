package com.scryfall.scryfallback.pages.card.controller;

import com.scryfall.scryfallback.pages.card.model.response.Card;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.pages.card.service.CardService;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/card")
@Slf4j
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("get")
    public Card getCardById(@RequestBody Card card) {
        return cardService.getCardById(card);
    }

    @PostMapping("rulings")
    public RulingWrapper getCardRulings(@RequestBody Card card) {
        return cardService.getCardRulings(card);
    }

    @PostMapping("search")
    public CardWrapper getCardsBySearch(@RequestBody SearchTerm searchTerm) {
        return cardService.getCardsBySearch(searchTerm);
    }
}
