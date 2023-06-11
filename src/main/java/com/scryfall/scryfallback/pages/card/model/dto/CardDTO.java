package com.scryfall.scryfallback.pages.card.model.dto;

import com.scryfall.scryfallback.pages.card.model.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardDTO {
    private Long cardId;
    private String id;

    public static List<CardDTO> fromEntityList(List<Card> cardList) {
        return cardList.stream().map(CardDTO::fromEntity).collect(Collectors.toList());
    }

    public static CardDTO fromEntity(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setCardId(card.getCard_id());
        cardDTO.setId(card.getId());
        return cardDTO;
    }

    public Card toEntity() {
        Card card = new Card();
        card.setCard_id(this.cardId);
        card.setId(this.id);
        return card;
    }
}
