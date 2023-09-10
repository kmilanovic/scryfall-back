package com.scryfall.scryfallback.pages.set.service;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import com.scryfall.scryfallback.pages.card.repository.CardRepository;
import com.scryfall.scryfallback.pages.set.model.dto.SetDTO;
import com.scryfall.scryfallback.pages.set.model.dto.SetIconDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import com.scryfall.scryfallback.pages.set.model.entity.SetIcon;
import com.scryfall.scryfallback.pages.set.model.response.SetWrapper;
import com.scryfall.scryfallback.pages.set.repository.SetRepository;
import com.scryfall.scryfallback.shared.ScryfallHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetServiceImpl implements SetService {

    private final SetRepository setRepository;
    private final CardRepository cardRepository;
    private final ScryfallHandler scryfallHandler;

    public SetServiceImpl(SetRepository setRepository, CardRepository cardRepository, ScryfallHandler scryfallHandler) {
        this.setRepository = setRepository;
        this.cardRepository = cardRepository;
        this.scryfallHandler = scryfallHandler;
    }

    @Override
    public SetWrapper getAllSetsFromAPI() {
        return scryfallHandler.getAllSets();
    }

    @Override
    public Page<SetDTO> getAllSets(Long userId, int pageIndex, int pageSize) {
        int indexOfPage = pageIndex - 1;
        Pageable pageable = PageRequest.of(indexOfPage, pageSize);
        Page<Set> setPage = setRepository.findAllByUserId(userId, pageable);

        List<SetDTO> setDTOList = SetDTO.fromEntityList(setPage.getContent(), userId);
        return new PageImpl<>(setDTOList, pageable, setPage.getTotalElements());
    }

    public List<SetDTO> getAllSets(Long userId) {
        List<Set> setList = setRepository.findAllByUserId(userId);
        return SetDTO.fromEntityList(setList, userId);
    }

    @Override
    public List<SetIconDTO> getAllSetIcons() {
        List<SetIcon> setIconList = setRepository.findAllIcons();
        return SetIconDTO.fromEntityList(setIconList);
    }

    @Override
    public void deleteSet(Long id) {
        setRepository.deleteById(id);
    }

    @Override
    public void deleteCardFromSet(Long setId, Long cardId) {
        Set set = setRepository.findById(setId).orElse(null);
        if (set != null) {
            List<Card> cards = set.getCards();
            cards.removeIf(card -> card.getCard_id().equals(cardId));
            setRepository.save(set);

            // Delete the card from the card table
            cardRepository.deleteById(cardId);
        }
    }

    @Override
    public Double getSetPrice(List<String> cardIds) {
        return scryfallHandler.getSetPrice(cardIds);
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
