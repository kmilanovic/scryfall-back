package com.scryfall.scryfallback.pages.set.service;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.set.model.dto.SetDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.model.response.SetWrapper;
import com.scryfall.scryfallback.pages.set.repository.SetRepository;
import com.scryfall.scryfallback.shared.ScryfallHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetServiceImpl implements SetService {

    private final SetRepository setRepository;
    private final ScryfallHandler scryfallHandler;

    public SetServiceImpl(SetRepository setRepository, ScryfallHandler scryfallHandler) {
        this.setRepository = setRepository;
        this.scryfallHandler = scryfallHandler;
    }

    @Override
    public SetWrapper getAllSetsFromAPI() {
        return scryfallHandler.getAllSets();
    }

    @Override
    public List<SetDTO> getAllSets(Long userId) {
        List<Set> setList = setRepository.findAllByUserId(userId);
        return SetDTO.fromEntityList(setList, userId);
    }

    @Override
    public Set addSet(Set set) {
        return setRepository.save(set);
    }

    @Override
    public void saveSetWithCards(Set set, List<Card> cards) {
        Set savedSet = setRepository.save(set);

        savedSet.setCards(cards);
        setRepository.save(savedSet);
    }
}
