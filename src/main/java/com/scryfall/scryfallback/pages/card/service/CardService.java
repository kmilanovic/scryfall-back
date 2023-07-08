package com.scryfall.scryfallback.pages.card.service;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.card.model.request.CardRequest;
import com.scryfall.scryfallback.pages.card.model.response.CardResponse;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.pages.set.model.request.SetRequest;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import com.scryfall.scryfallback.shared.model.command.ByIdCommand;
import com.scryfall.scryfallback.shared.model.command.SaveCardInSetCommand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CardService {

    CardResponse getCardById(CardRequest cardRequest);

    RulingWrapper getCardRulings(CardRequest cardRequest);

    CardWrapper getCardsBySearch(SearchTerm searchTerm);

    CardWrapper getCardsBySetCode(SetRequest setRequest);


    void saveCardInSet(SaveCardInSetCommand command);

    List<Card> getCardsBySet(ByIdCommand command);

    Page<Card> getCardsBySet(ByIdCommand command, int pageIndex, int pageSize);

    List<CardResponse> getRandomCard();

    List<CardResponse> getCardByMultiverse(CardRequest cardRequest);

    List<CardResponse> getCardByCatalog(CardRequest cardRequest);

    List<CardResponse> getCardByCardId(CardRequest cardRequest);
}
