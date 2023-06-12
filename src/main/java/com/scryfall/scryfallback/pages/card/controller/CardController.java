package com.scryfall.scryfallback.pages.card.controller;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.card.model.response.CardResponse;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.pages.card.service.CardService;
import com.scryfall.scryfallback.pages.set.model.response.SetResponse;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import com.scryfall.scryfallback.shared.model.command.ByIdCommand;
import com.scryfall.scryfallback.shared.model.command.SaveCardInSetCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/card")
@Slf4j
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("get")
    public CardResponse getCardById(@RequestBody CardResponse cardResponse) {
        return cardService.getCardById(cardResponse);
    }

    @PostMapping("rulings")
    public RulingWrapper getCardRulings(@RequestBody CardResponse cardResponse) {
        return cardService.getCardRulings(cardResponse);
    }

    @PostMapping("search")
    public CardWrapper getCardsBySearch(@RequestBody SearchTerm searchTerm) {
        return cardService.getCardsBySearch(searchTerm);
    }

    @PostMapping("search-by-code")
    public CardWrapper getCardsBySetCode(@RequestBody SetResponse setResponse) {
        return cardService.getCardsBySetCode(setResponse);
    }

    @PostMapping("save-in-set")
    public void saveCardInSets(@RequestBody SaveCardInSetCommand command) {
        cardService.saveCardInSet(command);
    }

    @GetMapping("get-by-set")
    public List<Card> getCardsBySet(@RequestBody ByIdCommand command) {
        return cardService.getCardsBySet(command);
    }
}
