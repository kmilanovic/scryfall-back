package com.scryfall.scryfallback.pages.card.controller;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.card.model.request.CardRequest;
import com.scryfall.scryfallback.pages.card.model.response.CardResponse;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.pages.card.service.CardService;
import com.scryfall.scryfallback.pages.set.model.request.SetRequest;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import com.scryfall.scryfallback.shared.model.command.ByIdCommand;
import com.scryfall.scryfallback.shared.model.command.SaveCardInSetCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    public CardResponse getCardById(@RequestBody CardRequest cardRequest) {
        return cardService.getCardById(cardRequest);
    }

    @PostMapping("rulings")
    public RulingWrapper getCardRulings(@RequestBody CardRequest cardRequest) {
        return cardService.getCardRulings(cardRequest);
    }

    @PostMapping("search")
    public CardWrapper getCardsBySearch(@RequestBody SearchTerm searchTerm) {
        return cardService.getCardsBySearch(searchTerm);
    }

    @PostMapping("search-by-code")
    public CardWrapper getCardsBySetCode(@RequestBody SetRequest setRequest) {
        return cardService.getCardsBySetCode(setRequest);
    }

    @PostMapping("save-in-set")
    public void saveCardInSets(@RequestBody SaveCardInSetCommand command) {
        cardService.saveCardInSet(command);
    }

    @PostMapping("get-by-set")
    public List<Card> getCardsBySet(@RequestBody ByIdCommand command) {
        return cardService.getCardsBySet(command);
    }

    @PostMapping("/get-by-set-paginated")
    public Page<Card> getAllCardsBySetPaginated(
            @RequestBody ByIdCommand command,
            @RequestParam(defaultValue = "0") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize) {
        return cardService.getCardsBySet(command, pageIndex, pageSize);
    }

    @GetMapping("random")
    public List<CardResponse> getRandomCard() {
        return cardService.getRandomCard();
    }

    @PostMapping("by-multiverse")
    public List<CardResponse> getCardByMultiverse(@RequestBody CardRequest cardRequest) {
        return cardService.getCardByMultiverse(cardRequest);
    }

    @PostMapping("by-catalog")
    public List<CardResponse> getCardByCatalog(@RequestBody CardRequest cardRequest) {
        return cardService.getCardByCatalog(cardRequest);
    }

    @PostMapping("by-id")
    public List<CardResponse> getCardByCardId(@RequestBody CardRequest cardRequest) {
        return cardService.getCardByCardId(cardRequest);
    }
}
