package com.scryfall.scryfallback.pages.set.service;


import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.set.model.dto.SetDTO;
import com.scryfall.scryfallback.pages.set.model.dto.SetIconDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.model.response.SetWrapper;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SetService {

    Page<SetDTO> getAllSets(Long userId, int pageIndex, int pageSize);

    List<SetDTO> getAllSets(Long userId);

    Set addSet(Set set);

    SetWrapper getAllSetsFromAPI();

    void saveSetWithCards(Set set, List<Card> cards);

    List<SetIconDTO> getAllSetIcons();
}
