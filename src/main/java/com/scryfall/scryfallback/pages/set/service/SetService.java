package com.scryfall.scryfallback.pages.set.service;


import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.set.model.dto.SetDTO;
import com.scryfall.scryfallback.pages.set.model.dto.SetIconDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.model.response.SetWrapper;

import java.util.List;

public interface SetService {

    List<SetDTO> getAllSets(Long userId);

    Set addSet(Set set);

    SetWrapper getAllSetsFromAPI();

    void saveSetWithCards(Set set, List<Card> cards);

    List<SetIconDTO> getAllSetIcons();
}
