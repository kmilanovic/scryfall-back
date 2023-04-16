package com.scryfall.scryfallback.pages.set.service;

import com.scryfall.scryfallback.pages.set.model.dto.SetDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.repository.SetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetServiceImpl implements SetService {

    private final SetRepository setRepository;

    public SetServiceImpl(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @Override
    public List<SetDTO> getAllSets() {
        List<Set> setList = setRepository.findAll();
        return SetDTO.fromEntityList(setList);
    }

    @Override
    public Set addSet(Set set) {
        return setRepository.save(set);
    }
}
