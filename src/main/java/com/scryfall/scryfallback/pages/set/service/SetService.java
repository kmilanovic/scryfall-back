package com.scryfall.scryfallback.pages.set.service;


import com.scryfall.scryfallback.pages.set.model.dto.SetDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;

import java.util.List;

public interface SetService {

    List<SetDTO> getAllSets();

    Set addSet(Set set);

}
