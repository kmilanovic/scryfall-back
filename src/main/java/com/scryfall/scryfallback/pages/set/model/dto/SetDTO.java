package com.scryfall.scryfallback.pages.set.model.dto;

import com.scryfall.scryfallback.pages.card.model.dto.CardDTO;
import com.scryfall.scryfallback.pages.set.model.entity.Set;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SetDTO {
    private Long set_id;
    private String name;
    private String icon_svg_uri;
    private Long user_id;
    private List<CardDTO> cards;

    public static List<SetDTO> fromEntityList(List<Set> setList, Long userId) {
        return setList.stream()
                .filter(s -> s.getUser_id().equals(userId))
                .map(SetDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public static SetDTO fromEntity(Set s) {
        SetDTO setDTO = new SetDTO();
        setDTO.setSet_id(s.getSet_id());
        setDTO.setName(s.getName());
        setDTO.setIcon_svg_uri(s.getIcon_svg_uri());
        setDTO.setUser_id(s.getUser_id());
        setDTO.setCards(CardDTO.fromEntityList(s.getCards()));
        return setDTO;
    }

    public Set toEntity() {
        Set s = new Set();
        s.setIcon_svg_uri(this.icon_svg_uri);
        s.setUser_id(this.user_id);
        // Set cards property if available
        //s.setCards(this.cards);
        return s;
    }
}
