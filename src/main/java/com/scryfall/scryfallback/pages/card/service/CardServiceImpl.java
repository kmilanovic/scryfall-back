package com.scryfall.scryfallback.pages.card.service;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.card.model.response.CardResponse;
import com.scryfall.scryfallback.pages.card.model.response.CardWrapper;
import com.scryfall.scryfallback.pages.card.repository.CardRepository;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.model.response.SetResponse;
import com.scryfall.scryfallback.pages.set.repository.SetRepository;
import com.scryfall.scryfallback.shared.ScryfallHandler;
import com.scryfall.scryfallback.shared.model.RulingWrapper;
import com.scryfall.scryfallback.shared.model.SearchTerm;
import com.scryfall.scryfallback.shared.model.command.ByIdCommand;
import com.scryfall.scryfallback.shared.model.command.SaveCardInSetCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CardServiceImpl implements CardService {
    private final ScryfallHandler scryfallHandler;
    private final CardRepository cardRepository;
    private final SetRepository setRepository;

    public CardServiceImpl(ScryfallHandler scryfallHandler, CardRepository cardRepository, SetRepository setRepository) {
        this.scryfallHandler = scryfallHandler;
        this.cardRepository = cardRepository;
        this.setRepository = setRepository;
    }


    @Override
    public CardResponse getCardById(CardResponse cardResponse) {
        return scryfallHandler.getCardById(cardResponse);
    }

    @Override
    public RulingWrapper getCardRulings(CardResponse cardResponse) {
        return scryfallHandler.getCardRulings(cardResponse);
    }

    @Override
    public CardWrapper getCardsBySearch(SearchTerm searchTerm) {
        return scryfallHandler.getCardsBySearch(searchTerm);
    }

    @Override
    public CardWrapper getCardsBySetCode(SetResponse setResponse) {
        return scryfallHandler.getCardsBySetCode(setResponse);
    }

    @Override
    public void saveCardInSet(SaveCardInSetCommand command) {
        Card card = new Card();
        card.setId(command.getCardId());
        Optional<Set> setOptional = setRepository.findById(command.getSetId());
        com.scryfall.scryfallback.pages.set.model.entity.Set set = setOptional.orElseThrow(() ->
                new IllegalArgumentException("Set not found with ID: " + command.getSetId()));

        card.getSets().add(set);

        set.getCards().add(card);

        cardRepository.save(card);
        setRepository.save(set);
    }

    @Override
    public List<Card> getCardsBySet(ByIdCommand command) {
        Optional<Set> set = setRepository.findById(command.getId());
        return set.get().getCards();
    }
}
